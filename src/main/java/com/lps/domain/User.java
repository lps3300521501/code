package com.lps.domain;
/**
 * 实体类属性与数据库列名不一致时采取两种方法：
 * 1.在USerDao.xml中的SQL语法使用别名
 * 2.在UserDao.xml中配置resultMap(实体类与属性名的对应关系)
 * 3.执行效率高用1，开发效率高用2
 */

import java.util.Date;

public class User {
    private Integer userid;
    private String username;
    private String useraddress;
    private String usersex;
    private Date userbirthday;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userbirthday=" + userbirthday +
                '}';
    }
}
