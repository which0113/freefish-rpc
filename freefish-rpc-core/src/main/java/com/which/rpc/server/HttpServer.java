package com.which.rpc.server;

/**
 * HTTP 服务器接口
 *
 * @author which
 */
public interface HttpServer {

    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}