package com.which.example.consumer;

import com.which.example.common.model.User;
import com.which.example.common.service.UserService;
import com.which.starter.annotation.RpcReference;
import org.springframework.stereotype.Service;

/**
 * 示例服务
 *
 * @author which
 * @date 2024/03/17
 */
@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("which");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}