package com.which.example.provider;

import com.which.example.common.service.UserService;
import com.which.rpc.bootstrap.ProviderBootstrap;
import com.which.rpc.model.ServiceRegisterInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 简易服务提供者示例
 *
 * @author which
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务信息
        ServiceRegisterInfo<UserServiceImpl> serviceRegisterInfo = new ServiceRegisterInfo<>(UserService.class.getName(), UserServiceImpl.class);
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}