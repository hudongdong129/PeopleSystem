package com.hu.util.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 分页标签
 */
public class PagerTag extends SimpleTagSupport {

    /** 定义请求URL中的占位符常量 */
    private static final String TAG = "{0}";

    /** 当前页码 */
    private Integer pageIndex;

    /** 每页显示的数量 */
    private Integer pageSize;

    /** 总记录条数 */
    private Integer recordCount;

    /** 请求url page.action?pageIndex={0} */
    private String submitUrl;

    /** 样式 */
    private String style = "sabrosus";

    /** 定义总页数 */
    private Integer totalPage = 0;

    @Override
    public void doTag() throws JspException, IOException {

        /** 定义它拼接最终的结果 */
        StringBuilder res = new StringBuilder();

        //定义它拼接中间的页码
        StringBuilder str = new StringBuilder();

        if (recordCount >0) {
            totalPage = (this.recordCount - 1) / this.pageSize + 1;
            if (this.pageSize == 1) { //首页
                str.append("<span class='disabled'>上一页</span>");
                this.calcPage(str); // 计算中间的页码
                if (this.pageIndex == totalPage) {
                    str.append("<span class='disabled'>上一页</span>");

                }else{
                    String tempUrl = this.submitUrl.replace(TAG,String.valueOf(pageIndex+1));
                    str.append("<a href='"+tempUrl+"'>下一页</a>");
                }
            } else if (this.pageIndex == totalPage) { //尾页
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(pageIndex - 1));
                str.append("<a href='" + tempUrl + "'>上一页</a>");
                this.calcPage(str);
                str.append("<span class='disabled'>下一页</span>");

            } else { //中间
                String tempUrl = this.submitUrl.replace(TAG,String.valueOf(pageIndex-1));
                str.append("<a href='"+tempUrl+"'>上一页</a>");
                this.calcPage(str);
                tempUrl = this.submitUrl.replace(TAG,String.valueOf(pageIndex+1));
                str.append("<a href='"+tempUrl+"'>下一页</a>");

            }
            res.append("<table width='100%' align='center' style='font-size:13px;' class='"+style+"'>");
            res.append("<tr><td style='color:#0061de; margin-right:3px; padding-top:2px; text-decoration:none'>"+str.toString());
            res.append("&nbsp;跳 转 到 &nbsp;&nbsp;<input style='text-align:center;border-right:#aaaadd 1px solid;" +
                    "padding-right:5px; border-top:#aaaadd 1px solid; padding-left: 5px;padding-bottom:2px; margin: 2px;border-left:#aaaadd 1px solid;" +
                    "color:#000099; padding-top: 2px; border-bottom:#aaaadd 1px solid; text-decoration:none' type='text' size='2' id='page_jump_page_size'/>");


        }

        super.doTag();
    }

    /**
     * 计算中间页的方法
     * @author huDong
     * @date 2018/10/14 下午1:30
     * @param []
     * @return void
     */
    private void calcPage(StringBuilder str) {
        if (this.totalPage <= 11) {
            for (int i = 1; i <= this.totalPage; i++) {
                if (this.pageIndex == i) {
                    str.append("<span class='current'>" + i + "</span>");
                } else {
                    String tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                    str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                }
            }
        } else {
            if (this.pageIndex <= 8) {
                for (int i = 1; i <= 10; i++) {
                    if (this.pageIndex == i) {
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        String tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                        str.append("<a href='"+tempUrl+"'>"+i+"</a>");
                    }
                }
                str.append("...");
                String tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.totalPage));
                str.append("<a href='"+tempUrl+"'>"+this.totalPage+"</a>");

            } else if (this.pageIndex + 8 >= this.totalPage) {
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
                str.append("<a href='" + tempUrl + "'>1</a>");
                str.append("...");
                for (int i = this.totalPage - 10; i <= this.totalPage; i++) {
                    if (this.pageIndex == i) {
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                        str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                    }
                }
            } else {

                String tempUrl = this.submitUrl.replace(TAG,String.valueOf(1));
                str.append("<a href='"+tempUrl+"'>1</a>");
                str.append("...");
                for (int i = this.pageIndex - 4; i <= this.pageIndex + 4; i++) {
                    if (this.pageIndex == i) {
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                        str.append("<a href='"+tempUrl+"'>"+this.totalPage+"</a>");
                    }
                }
            }

        }

    }
}
