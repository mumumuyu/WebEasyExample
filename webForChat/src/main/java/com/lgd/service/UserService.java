package com.lgd.service;

import com.lgd.dao.UserDao;
import com.lgd.pojo.User;

public class UserService {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }
    //用户登录
    public User login(String id, String password){
        User user = userDao.getUserById(id);
        if (null != user) {
            if (!user.getPwd().equals(password)) {
                user = null;
            }
        }
        return user;
    }
}
