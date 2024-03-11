package com.which.rpc.registry;

import com.which.rpc.spi.SpiLoader;

/**
 * 注册中心工厂（用于获取注册中心对象）
 *
 * @author which
 */
public class RegistryFactory {

    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    static {
        SpiLoader.load(Registry.class);
    }

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Registry getInstance(String key) {
        return SpiLoader.getInstance(Registry.class, key);
    }

}
