package com.which.rpc.proxy;

import cn.hutool.core.collection.CollUtil;
import com.which.rpc.RpcApplication;
import com.which.rpc.config.RpcConfig;
import com.which.rpc.model.RpcRequest;
import com.which.rpc.model.RpcResponse;
import com.which.rpc.model.ServiceMetaInfo;
import com.which.rpc.registry.Registry;
import com.which.rpc.registry.RegistryFactory;
import com.which.rpc.serializer.Serializer;
import com.which.rpc.serializer.SerializerFactory;
import com.which.rpc.server.tcp.VertxTcpClient;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import static com.which.rpc.constant.RpcConstant.DEFAULT_SERVICE_VERSION;

/**
 * 服务代理（JDK 动态代理）
 *
 * @author which
 */
public class ServiceProxy implements InvocationHandler {

    /**
     * 调用代理
     *
     * @param proxy  代理
     * @param method 方法
     * @param args   args
     * @return 对象
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 指定序列化器
        String serializerName = RpcApplication.getRpcConfig().getSerializer();
        final Serializer serializer = SerializerFactory.getInstance(serializerName);

        // 构造请求
        String serviceName = method.getDeclaringClass().getName();
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(serviceName)
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();
        try {
            // 序列化
            byte[] bodyBytes = serializer.serialize(rpcRequest);

            // 从注册中心获取服务提供者请求地址
            RpcConfig rpcConfig = RpcApplication.getRpcConfig();
            Registry registry = RegistryFactory.getInstance(rpcConfig.getRegistryConfig().getRegistry());
            ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
            serviceMetaInfo.setServiceName(serviceName);
            serviceMetaInfo.setServiceVersion(DEFAULT_SERVICE_VERSION);
            List<ServiceMetaInfo> serviceMetaInfoList = registry.serviceDiscovery(serviceMetaInfo.getServiceKey());
            if (CollUtil.isEmpty(serviceMetaInfoList)) {
                throw new RuntimeException("暂无服务地址");
            }
            // 暂时先取第一个
            ServiceMetaInfo selectedServiceMetaInfo = serviceMetaInfoList.get(0);

            // 发送 TCP 请求
            RpcResponse rpcResponse = VertxTcpClient.doRequest(rpcRequest, selectedServiceMetaInfo);
            return rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}