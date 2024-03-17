package com.which.example.provider;

import com.which.starter.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot提供程序应用程序示例
 *
 * @author which
 * @date 2024/03/17
 */
@EnableRpc
@SpringBootApplication
public class ExampleSpringbootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringbootProviderApplication.class, args);
    }

}
