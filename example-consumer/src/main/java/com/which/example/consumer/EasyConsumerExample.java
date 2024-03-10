package com.which.example.consumer;

import com.which.example.common.model.User;
import com.which.example.common.service.UserService;
import com.which.rpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 *
 * @author which
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 动态代理 获取 userService
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("which");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }

//        long number = userService.getNumber();
//        System.out.println(number);
    }
}