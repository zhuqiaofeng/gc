package com.hz.gc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.hz.gc.dao")
@EnableTransactionManagement
public class GcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcApplication.class, args);
    }

}
