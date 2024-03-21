package com.which.starter.bootstrap;

import cn.hutool.core.bean.BeanUtil;
import com.which.rpc.RpcApplication;
import com.which.rpc.config.RegistryConfig;
import com.which.rpc.config.RpcConfig;
import com.which.rpc.model.ServiceMetaInfo;
import com.which.rpc.registry.LocalRegistry;
import com.which.rpc.registry.Registry;
import com.which.rpc.registry.RegistryFactory;
import com.which.starter.annotation.RpcService;
import com.which.starter.client.RpcClient;
import com.which.starter.config.RpcSdkConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.Resource;

/**
 * Rpc 服务提供者启动
 *
 * @author which
 * @date 2024/03/17
 */
@Slf4j
public class RpcProviderBootstrap implements BeanPostProcessor {

    @Resource
    private RpcClient rpcClient;

    /**
     * Bean 初始化后执行，注册服务
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        RpcService rpcService = beanClass.getAnnotation(RpcService.class);
        if (rpcService != null) {
            // 需要注册服务
            // 1. 获取服务基本信息
            Class<?> interfaceClass = rpcService.interfaceClass();
            // 默认值处理
            if (interfaceClass == void.class) {
                interfaceClass = beanClass.getInterfaces()[0];
            }
            String serviceName = interfaceClass.getName();
            String serviceVersion = rpcService.serviceVersion();
            // 2. 注册服务
            // 本地注册
            LocalRegistry.register(serviceName, beanClass);

            RpcSdkConfig rpcSdkConfig = rpcClient.getRpcSdkConfig();
            RpcConfig rpcConfig = new RpcConfig();
            BeanUtil.copyProperties(rpcSdkConfig, rpcConfig);
            // 添加到全局配置
            RpcApplication.init(rpcConfig);

            // 注册服务到注册中心
            RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
            Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceVersion(serviceVersion);
            serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
            serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
            try {
                registry.register(serviceMetaInfo);
            } catch (Exception e) {
                throw new RuntimeException(serviceName + " 服务注册失败", e);
            }
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}