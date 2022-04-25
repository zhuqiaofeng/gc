package com.hz.gc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hz.gc.dao")
public class GcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcApplication.class, args);
    }

}
