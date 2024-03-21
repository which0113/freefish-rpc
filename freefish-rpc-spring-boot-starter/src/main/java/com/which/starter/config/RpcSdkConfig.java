package com.which.starter.config;

import com.which.starter.client.RpcClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static com.which.rpc.fault.retry.RetryStrategyKeys.NO;
import static com.which.rpc.fault.tolerant.TolerantStrategyKeys.FAIL_FAST;
import static com.which.rpc.loadbalancer.LoadBalancerKeys.ROUND_ROBIN;
import static com.which.rpc.registry.RegistryKeys.ETCD;
import static com.which.rpc.serializer.SerializerKeys.JDK;

/**
 * RPC 框架配置
 *
 * @author which
 * @date 2024/03/21
 */
@Data
@Configuration
@ConfigurationProperties("com.which.rpc")
@ComponentScan
public class RpcSdkConfig {

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

    @Bean
    public RpcClient rpcClient() {
        RpcSdkConfig rpcSdkConfig = new RpcSdkConfig();
        rpcSdkConfig.setName(name);
        rpcSdkConfig.setVersion(version);
        rpcSdkConfig.setServerHost(serverHost);
        rpcSdkConfig.setServerPort(serverPort);
        rpcSdkConfig.setMock(mock);
        rpcSdkConfig.setSerializer(serializer);
        rpcSdkConfig.setRegistryConfig(registryConfig);
        rpcSdkConfig.setLoadBalancer(loadBalancer);
        rpcSdkConfig.setRetryStrategy(retryStrategy);
        rpcSdkConfig.setTolerantStrategy(tolerantStrategy);
        return new RpcClient(rpcSdkConfig);
    }

    @Data
    public static class RegistryConfig {

        /**
         * 注册中心类别
         */
        private String registry = ETCD;

        /**
         * 注册中心地址
         */
        private String address = "http://localhost:2380";

        /**
         * 用户名
         */
        private String username;

        /**
         * 密码
         */
        private String password;

        /**
         * 超时时间（单位毫秒）
         */
        private Long timeout = 10000L;

    }

}