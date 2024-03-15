package com.which.rpc.fault.retry;

/**
 * 重试策略键常量
 *
 * @author which
 * @date 2024/03/15
 */
public interface RetryStrategyKeys {

    /**
     * 不重试
     */
    String NO = "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";

}