package com.hu.controller;

import java.util.*;

public class LinkedListTest {

    public static void main(String[] args) {

        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(7);
        ListIterator listIterator = a.listIterator();
        if (listIterator.hasNext()) {
            listIterator.next();
            listIterator.add(2);
        }
        System.out.println(a);


//        List<String> a = new LinkedList<>();
//        a.add("Amy");
//        a.add("Carl");
//        a.add("Eria");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
//
//        ListIterator<String> aIter = a.listIterator();
//        Iterator<String> bIter = b.iterator();

//        while (bIter.hasNext()) {
//            if (aIter.hasNext()) {
//                aIter.next();
//            }
//            aIter.add(bIter.next());
//        }
//
//        System.out.println(a);
//
//        bIter = b.iterator();
//        while (bIter.hasNext()) {
//            bIter.next();
//            if (bIter.hasNext()) {
//                bIter.next();
//                bIter.remove();
//            }
//        }
//        System.out.println(b);
//        System.out.println(b.size());
//
//        a.removeAll(b);
//
//        System.out.println(a);

    }
}
