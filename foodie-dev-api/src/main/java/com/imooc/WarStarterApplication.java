package com.imooc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打包war包的启动类
 *
 * @author augenye
 * @date 2019/11/17 12:40 下午
 */
public class WarStarterApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //指向application这个springboot启动类
        return builder.sources(Application.class);
    }

}
