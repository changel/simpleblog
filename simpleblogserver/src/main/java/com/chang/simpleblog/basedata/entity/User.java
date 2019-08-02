package com.chang.simpleblog.basedata.entity;


import javax.persistence.*;

/**
 *  用户实体
 * @Author: chang.tong
 * @Date: 2019/8/2 14:46
 * @Version 1.0
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20,unique = true,nullable = false)
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 30)
    private String displayname;
    @Column(length = 1)
    private Integer sex;
    @Column(length = 20)
    private String phone;
    @Column(length = 50)
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "用户："+this.displayname+ "\n" +
                "登录名：" + this.username  ;
    }
}
