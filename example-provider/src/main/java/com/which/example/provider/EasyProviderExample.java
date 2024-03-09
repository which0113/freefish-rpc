package com.which.example.provider;

import com.which.example.common.service.UserService;
import com.which.rpc.registry.LocalRegistry;
import com.which.rpc.server.HttpServer;
import com.which.rpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 *
 * @author which
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}