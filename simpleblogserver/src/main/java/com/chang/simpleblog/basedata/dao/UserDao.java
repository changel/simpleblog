package com.chang.simpleblog.basedata.dao;
import com.chang.simpleblog.basedata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chang.tong
 * @Date: 2019/8/2 15:01
 * @Version 1.0
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    /**
     *  根据username查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * 根据展示名获取用户信息
     * @param displayname
     * @return
     */
    public List<User> findUserByDisplayname(String displayname);

    @Query(nativeQuery = true,value = "select * from BLOG_USER  WHERE displayName like CONCAT('%', :name ,'%')")
    public List<User> findUserByNameLike(@Param("name") String name);
}
