package com.chang.simpleblog.demo;

import com.chang.simpleblog.basedata.dao.UserDao;
import com.chang.simpleblog.basedata.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: chang.tong
 * @Date: 2019/8/2 15:03
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserDao userDao;

    @Before
    public void before(){
//        User user  = new User();
//        user.setUsername("tom");
//        user.setPassword("111");
//        user.setDisplayname("Tom");
//        userDao.save(user);
//        user = new User();
//        user.setUsername("jane");
//        user.setPassword("111");
//        user.setDisplayname("Jane");
//        userDao.save(user);
    }
    @Test
    public void saveUserTest(){
        User user  = new User();
        user.setUsername("admin");
        user.setPassword("111");
        user.setDisplayname("admin");
        userDao.save(user);
    }
    @Test
    public void queryUserTest(){
        List<User> users = userDao.findUserByNameLike("m");
        for(User user : users){
            System.out.println(user);
        }
        User use =  userDao.findUserByUsername("admin");
        System.out.println(use);
    }
    @After
    public void after(){
//        List<User> users = userDao.findUserByDisplayName("Tom");
//        userDao.deleteInBatch(users);
//        users = userDao.findUserByDisplayName("Jane");
//        userDao.deleteInBatch(users);
//        users = userDao.findUserByDisplayName("admin");
//        userDao.deleteInBatch(users);
//        User user = userDao.findUserByUserName("tom");
//        userDao.delete(user);
//        user = userDao.findUserByUserName("jane");
//        userDao.delete(user);
    }
}
