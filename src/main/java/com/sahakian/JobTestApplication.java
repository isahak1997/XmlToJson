package com.sahakian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class JobTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobTestApplication.class, args);
    }
}
