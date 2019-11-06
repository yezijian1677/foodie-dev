package com.imooc.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author augenye
 * @date 2019-11-06 16:21
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    //localhost:8088/swagger-ui.html
    //localhost:8088/doc.html

    /**
     * 配置swagger2核心配置 docket
     * @return
     */
    public Docket createRestApi() {
        //指定类型
        return new Docket(DocumentationType.SWAGGER_2)
                //定义api文档汇总信息
                .apiInfo(apiInfo())
                //配置扫描包所在的地址
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.imooc.controller"))
                //所有controller
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 定义api个人信息
     * @return api
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口api")
                .contact(new Contact("yezijian", "augenye.com", "1677390657@qq.com"))
                .description("专为天天吃货提供的api文档")
                .version("1.0.1")
                .termsOfServiceUrl("augenye.com")
                .build();
    }
}
