package com.which.starter.client;

import com.which.starter.config.RpcSdkConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RPC 客户端
 *
 * @author which
 * @date 2024/03/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcClient {

    private RpcSdkConfig rpcSdkConfig;

}