package com.which.rpc.fault.tolerant;

import com.which.rpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 降级到其他服务 - 容错策略
 *
 * @author which
 * @date 2024/03/16
 */
@Slf4j
public class FailBackTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 待扩展，获取降级的服务并调用
        return null;
    }
}