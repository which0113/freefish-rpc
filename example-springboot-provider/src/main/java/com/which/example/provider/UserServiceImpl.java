package com.which.example.provider;

import com.which.example.common.model.User;
import com.which.example.common.service.UserService;
import com.which.starter.annotation.RpcService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author which
 * @date 2024/03/17
 */
@RpcService
@Service
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}