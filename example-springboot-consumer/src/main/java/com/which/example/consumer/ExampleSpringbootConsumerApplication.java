package com.which.example.consumer;

import com.which.starter.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot使用者应用程序示例
 *
 * @author which
 * @date 2024/03/17
 */
@EnableRpc(needServer = false)
@SpringBootApplication
public class ExampleSpringbootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringbootConsumerApplication.class, args);
    }

}
