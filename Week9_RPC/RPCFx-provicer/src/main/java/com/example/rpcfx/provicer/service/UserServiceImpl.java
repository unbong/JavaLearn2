package com.example.rpcfx.provicer.service;

import com.unbong.api.User;
import com.unbong.api.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(int Id) {

        User user = new User();
        user.setUserId(1);
        user.setUserName("unbong");
        return user;
    }
}
