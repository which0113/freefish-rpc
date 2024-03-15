package com.which.rpc.config;

import lombok.Data;

import static com.which.rpc.registry.RegistryKeys.ETCD;

/**
 * RPC 框架注册中心配置
 *
 * @author which
 */
@Data
public class RegistryConfig {

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