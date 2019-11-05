package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author augenye
 * @date 2019-11-04 22:57
 * Spring boot 自动装配，运行的时候通过SpringApplication去run
 * 扫描子包下的bean
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
