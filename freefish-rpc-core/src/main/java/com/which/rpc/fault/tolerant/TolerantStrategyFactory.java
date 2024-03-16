package com.which.rpc.fault.tolerant;

import com.which.rpc.spi.SpiLoader;

/**
 * 容错策略工厂（工厂模式，用于获取容错策略对象）
 *
 * @author which
 * @date 2024/03/16
 */
public class TolerantStrategyFactory {

    /**
     * 默认容错策略
     */
    private static final TolerantStrategy DEFAULT_RETRY_STRATEGY = new FailFastTolerantStrategy();

    static {
        SpiLoader.load(TolerantStrategy.class);
    }

    /**
     * 获取实例
     *
     * @param key 钥匙
     * @return 容错策略
     */
    public static TolerantStrategy getInstance(String key) {
        return SpiLoader.getInstance(TolerantStrategy.class, key);
    }

}