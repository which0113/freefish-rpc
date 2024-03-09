package com.which.example.provider;

import com.which.example.common.model.User;
import com.which.example.common.service.UserService;

/**
 * 用户服务实现类
 *
 * @author which
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}