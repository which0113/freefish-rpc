package com.which.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.which.rpc.constant.RpcConstant.DEFAULT_SERVICE_VERSION;

/**
 * 服务提供者注解（用于注册服务）
 *
 * @author which
 * @date 2024/03/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    /**
     * 服务接口类
     */
    Class<?> interfaceClass() default void.class;

    /**
     * 版本
     */
    String serviceVersion() default DEFAULT_SERVICE_VERSION;
}