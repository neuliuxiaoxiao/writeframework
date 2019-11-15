package com.neu.mybatis.bean;

/**
 * @Title User
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 14:52
 **/
public class User {

    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
