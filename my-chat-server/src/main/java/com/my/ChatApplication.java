package com.my;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.io.support.SpringFactoriesLoader;


/**
 * @Author kejie
 * @Date 2023/3/7 17:59
 * @PackageName:com.my
 * @ClassName: ChatApplication
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
        DefaultIdentifierGenerator generator = new DefaultIdentifierGenerator();
    }
}
