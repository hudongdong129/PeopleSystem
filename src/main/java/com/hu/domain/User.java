package com.hu.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer id;  //id

    /** 登录名 */
    private String loginname;

    /** 密码 */
    private String password;

    /** 用户名 */
    private String username;

    /** 状态 */
    private Integer status;

    /** 建档日期 */
    private Date createDate;

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
