package com.chang.simpleblog.basedata.entity;

import javax.persistence.*;

/**
 * @Author: chang.tong
 * @Date: 2019/8/12 15:33
 * @Version 1.0
 */
@Entity
@Table(name = "Blog_RightAuth")
public class RightAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user; //用户

    @Column(length = 100)
    private String sourceid;  //授权对象id

    @Column(length = 100)
    private String sourceentity;  //授权对象名称

    private String righttype; //授权类型

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getSourceentity() {
        return sourceentity;
    }

    public void setSourceentity(String sourceentity) {
        this.sourceentity = sourceentity;
    }

    public String getRighttype() {
        return righttype;
    }

    public void setRighttype(String righttype) {
        this.righttype = righttype;
    }
}
