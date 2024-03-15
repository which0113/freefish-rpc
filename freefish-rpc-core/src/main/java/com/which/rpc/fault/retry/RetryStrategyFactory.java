package com.which.rpc.fault.retry;

import com.which.rpc.spi.SpiLoader;

/**
 * 重试策略工厂
 *
 * @author which
 * @date 2024/03/15
 */
public class RetryStrategyFactory {

    /**
     * 默认重试器
     */
    private static final RetryStrategy DEFAULT_RETRY_STRATEGY = new NoRetryStrategy();

    static {
        SpiLoader.load(RetryStrategy.class);
    }

    /**
     * 获取实例
     *
     * @param key 钥匙
     * @return 重试策略
     */
    public static RetryStrategy getInstance(String key) {
        return SpiLoader.getInstance(RetryStrategy.class, key);
    }

}