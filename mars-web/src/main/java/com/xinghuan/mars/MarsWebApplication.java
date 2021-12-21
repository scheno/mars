package com.xinghuan.mars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenchen
 * @version 1.0
 * @date 2021/12/20 3:15 下午
 */
@MapperScan("com.xinghuan.mars.repository")
@SpringBootApplication
public class MarsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsWebApplication.class);
    }
}
