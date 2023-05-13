package com.cdu.SoulMate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author luokunsong
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.cdu.SoulMate.mapper")
public class SoulMateBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoulMateBackendApplication.class, args);
    }
}
