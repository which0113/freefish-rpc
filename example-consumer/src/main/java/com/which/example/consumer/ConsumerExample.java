package com.which.example.consumer;

import com.which.rpc.config.RpcConfig;
import com.which.rpc.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 *
 * @author which
 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}