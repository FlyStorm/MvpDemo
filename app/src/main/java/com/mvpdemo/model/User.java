package com.mvpdemo.model;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/4/6 0006 21:35
 * 作用	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class User {
    private String name;
    private String password;
    public User(String name,String password){
        this.name=name;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
