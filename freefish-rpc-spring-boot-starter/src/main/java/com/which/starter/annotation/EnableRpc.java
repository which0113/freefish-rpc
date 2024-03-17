package com.which.starter.annotation;

import com.which.starter.bootstrap.RpcConsumerBootstrap;
import com.which.starter.bootstrap.RpcInitBootstrap;
import com.which.starter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用 Rpc 注解
 *
 * @author which
 * @date 2024/03/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
public @interface EnableRpc {

    /**
     * 需要启动 server
     *
     * @return boolean
     */
    boolean needServer() default true;
}