package com.which.rpc.fault.retry;

import com.which.rpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * 重试策略
 *
 * @author which
 * @date 2024/03/15
 */
public interface RetryStrategy {

    /**
     * 重试
     *
     * @param callable 可赎回
     * @return RPC响应
     * @throws Exception 例外
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}