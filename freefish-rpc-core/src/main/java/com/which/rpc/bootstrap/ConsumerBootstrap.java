package com.which.rpc.bootstrap;

import com.which.rpc.RpcApplication;

/**
 * 服务消费者启动类（初始化）
 *
 * @author which
 * @date 2024/03/17
 */
public class ConsumerBootstrap {

    /**
     * 初始化
     */
    public static void init() {
        // RPC 框架初始化（配置和注册中心）
        RpcApplication.init();
    }

}