package com.which.rpc.config;

import lombok.Data;

import static com.which.rpc.fault.retry.RetryStrategyKeys.NO;
import static com.which.rpc.fault.tolerant.TolerantStrategyKeys.FAIL_FAST;
import static com.which.rpc.loadbalancer.LoadBalancerKeys.ROUND_ROBIN;
import static com.which.rpc.serializer.SerializerKeys.JDK;

/**
 * RPC 框架配置
 *
 * @author which
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "freefish-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8888;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = JDK;

    /**
     * 注册配置中心
     */
    private RegistryConfig registryConfig = new RegistryConfig();

    /**
     * 负载均衡器
     */
    private String loadBalancer = ROUND_ROBIN;

    /**
     * 重试策略
     */
    private String retryStrategy = NO;

    /**
     * 容错策略
     */
    private String tolerantStrategy = FAIL_FAST;

}