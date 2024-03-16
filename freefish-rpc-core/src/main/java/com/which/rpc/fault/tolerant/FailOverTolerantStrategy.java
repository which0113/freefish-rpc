package com.which.rpc.fault.tolerant;

import com.which.rpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 转移到其他服务节点 - 容错策略
 *
 * @author which
 * @date 2024/03/16
 */
@Slf4j
public class FailOverTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 待扩展，获取其他服务节点并调用
        return null;
    }
}