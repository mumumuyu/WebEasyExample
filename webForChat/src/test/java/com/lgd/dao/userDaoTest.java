package com.lgd.dao;

import com.lgd.pojo.User;
import com.lgd.service.UserService;
import org.junit.jupiter.api.Test;

public class userDaoTest {
    @Test
    public void Test(){
//        UserDao userDao = new UserDao();
//        User user = userDao.getUserById("001");
//        System.out.println(user);
        UserService userService = new UserService();
        User user = userService.login("001","123456");
        System.out.println(user);
    }
}
