package com.which.starter.bootstrap;

import cn.hutool.setting.dialect.Props;
import com.which.rpc.server.tcp.VertxTcpServer;
import com.which.starter.annotation.EnableRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Optional;

/**
 * rpc init引导
 *
 * @author which
 * @date 2024/03/17
 */
@Slf4j
public class RpcInitBootstrap implements ImportBeanDefinitionRegistrar {

    /**
     * Spring 初始化时执行，初始化 RPC 框架
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取 EnableRpc 注解的属性值
        Map<String, Object> annotationAttributes = importingClassMetadata
                .getAnnotationAttributes(EnableRpc.class.getName());
        if (annotationAttributes == null) {
            log.error("启动 server 失败");
            return;
        }
        boolean needServer = (boolean) annotationAttributes.get("needServer");
        // 启动服务器
        if (needServer) {
            VertxTcpServer vertxTcpServer = new VertxTcpServer();
            Props props = new Props("application.yml");
            int serverPort = Integer.parseInt(Optional.ofNullable(props.get("server-port"))
                    .orElse(8888).toString());
            vertxTcpServer.doStart(serverPort);
        } else {
            log.info("不启动 server");
        }

    }
}