package com.imooc.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author augenye
 * @date 2019-11-06 19:22
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //实现静态资源的映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射所有的资源
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")//映射swagger2
                .addResourceLocations("file:/Users/yezijian/project/foodie-dev/images/");//映射本地静态资源

    }

    public WebMvcConfig() {

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
