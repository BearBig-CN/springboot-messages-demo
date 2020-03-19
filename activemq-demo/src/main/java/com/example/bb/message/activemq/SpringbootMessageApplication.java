package com.example.bb.message.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * ActiveMQ程序启动入口
 *
 * @author BB
 */
@SpringBootApplication
@EnableJms
@ComponentScan(basePackages = {"com.example.bb.common", "com.example.bb.message.activemq"})
public class SpringbootMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMessageApplication.class, args);
    }

}
