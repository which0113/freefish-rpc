package com.which.rpc.fault.tolerant;

import com.which.rpc.model.RpcResponse;

import java.util.Map;

/**
 * 容错策略
 *
 * @author which
 * @date 2024/03/16
 */
public interface TolerantStrategy {

    /**
     * 容错
     *
     * @param context 上下文，用于传递数据
     * @param e       异常
     * @return RPC响应
     */
    RpcResponse doTolerant(Map<String, Object> context, Exception e);
}