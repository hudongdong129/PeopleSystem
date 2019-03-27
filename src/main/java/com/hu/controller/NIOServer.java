package com.hu.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOServer {

    private static Charset charset = Charset.forName("UTF-8");

    private static CharsetDecoder decoder = charset.newDecoder();

    public static void main(String[] args) throws IOException {
        //1.创建一个selector
        Selector selector = Selector.open();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        int port = 9000;
        ssc.bind(new InetSocketAddress(port));

        //2.注册到selector
        ssc.configureBlocking(false); //设置为非阻塞

        //ssc向selector 注册，监听连接到来
        ssc.register(selector,SelectionKey.OP_ACCEPT);

        //连接计数
        int connectionCount = 0;
        //创建连接池
        int threads = 3;
        ExecutorService pool = Executors.newFixedThreadPool(threads);

        while (true) {
            //阻塞等待就绪的事件
            int readyChannelsCount = selector.select();
            if (readyChannelsCount == 0) {
                continue;
            }

            //得到就绪的channel的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    //接入连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //设置非阻塞
                    socketChannel.configureBlocking(false);
                    //向seletor注册
                    socketChannel.register(selector,SelectionKey.OP_READ,++connectionCount);

                } else if (key.isConnectable()) {

                } else if (key.isReadable()) {
                    //交给连接池去处理数据读
                    pool.execute(new SocketProcess(key));

                    //取消Selector注册，防止线程池处理不及时，重复选择
                    key.cancel();
                } else if (key.isWritable()) {

                }
                keyIterator.remove(); //从selectedKey中移除
            }
        }
    }

    static class SocketProcess implements Runnable{
        SelectionKey key;

        public SocketProcess(SelectionKey key) {
            super();
            this.key = key;
        }

        @Override
        public void run() {
            try {
                System.out.println("连接");
                //连接不需要了，就关闭
                key.channel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private String readFromChannel() throws IOException {
            SocketChannel socketChannel = (SocketChannel) key.channel();

            int bfSize = 1024;
            ByteBuffer buffer = ByteBuffer.allocateDirect(bfSize);

            //定义一个更大的buffer
            ByteBuffer bigBuffer = null;

            //读的次数计数
            int count = 0;
            while ((socketChannel.read(buffer)) != -1) {
                count++;

                ByteBuffer tempBuffer = ByteBuffer.allocateDirect(bfSize * (count + 1));

                if (bigBuffer != null) {
                    bigBuffer.flip();
                    tempBuffer.put(bigBuffer);
                }

                bigBuffer = tempBuffer;

                buffer.flip();
                bigBuffer.put(buffer);
                buffer.clear();


            }

            if (bigBuffer != null) {
                bigBuffer.flip();
                try {
                    return decoder.decode(bigBuffer).toString();
                } catch (CharacterCodingException e) {
                    e.getStackTrace();
                }
            }
            return null;
        }
    }

}
