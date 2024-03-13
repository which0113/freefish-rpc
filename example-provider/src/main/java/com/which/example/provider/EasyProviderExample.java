package com.which.example.provider;

import com.which.example.common.service.UserService;
import com.which.rpc.RpcApplication;
import com.which.rpc.config.RegistryConfig;
import com.which.rpc.config.RpcConfig;
import com.which.rpc.model.ServiceMetaInfo;
import com.which.rpc.registry.LocalRegistry;
import com.which.rpc.registry.Registry;
import com.which.rpc.registry.RegistryFactory;
import com.which.rpc.server.HttpServer;
import com.which.rpc.server.tcp.VertxTcpServer;

/**
 * 简易服务提供者示例
 *
 * @author which
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 tcp 服务
        HttpServer httpServer = new VertxTcpServer();
        httpServer.doStart(serviceMetaInfo.getServicePort());
    }
}