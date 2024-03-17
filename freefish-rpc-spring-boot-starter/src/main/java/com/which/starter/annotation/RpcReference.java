package com.which.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.which.rpc.constant.RpcConstant.DEFAULT_SERVICE_VERSION;
import static com.which.rpc.fault.retry.RetryStrategyKeys.NO;
import static com.which.rpc.fault.tolerant.TolerantStrategyKeys.FAIL_FAST;
import static com.which.rpc.loadbalancer.LoadBalancerKeys.ROUND_ROBIN;

/**
 * 服务消费者注解（用于注入服务）
 *
 * @author which
 * @date 2024/03/17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RpcReference {

    /**
     * 服务接口类
     */
    Class<?> interfaceClass() default void.class;

    /**
     * 版本
     */
    String serviceVersion() default DEFAULT_SERVICE_VERSION;

    /**
     * 负载均衡器
     */
    String loadBalancer() default ROUND_ROBIN;

    /**
     * 重试策略
     */
    String retryStrategy() default NO;

    /**
     * 容错策略
     */
    String tolerantStrategy() default FAIL_FAST;

    /**
     * 模拟调用
     */
    boolean mock() default false;

}