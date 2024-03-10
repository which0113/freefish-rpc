package com.which.rpc.serializer;

import com.which.rpc.spi.SpiLoader;

/**
 * 序列化器工厂（用于获取序列化器对象）
 *
 * @author which
 */
public class SerializerFactory {

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }

}