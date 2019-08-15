package com.chang.simpleblog.basedata.dao;

import com.chang.simpleblog.basedata.entity.RightAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chang.tong
 * @Date: 2019/8/12 15:47
 * @Version 1.0
 */
@Repository
public interface RightAuthDao  extends JpaRepository<RightAuth,Integer> {


    /**
     * 根据用户获取权限
     * @param username
     * @return
     */
    @Query(nativeQuery = true,value = "select r.* from Blog_RightAuth r,Blog_User u where r.userid=u.id and u.username=?")
    public List<RightAuth> findRightAuthByUserName(String username);
}
