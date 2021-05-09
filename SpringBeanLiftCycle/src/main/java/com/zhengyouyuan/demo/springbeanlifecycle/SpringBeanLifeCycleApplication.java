package com.zhengyouyuan.demo.springbeanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBeanLifeCycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanLifeCycleApplication.class, args);
    }

}
