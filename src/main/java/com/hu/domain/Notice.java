package com.hu.domain;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {

    /** id编号 */
    private Integer id;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 发布日期 */
    private Date createDate;

    /** 发布人 */
    private User user;

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
