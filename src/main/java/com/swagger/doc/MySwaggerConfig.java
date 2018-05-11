package com.swagger.doc;

/**
 * Created by haoyifen on 16-9-28 2016 下午5:43
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MySwaggerConfig {
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                 .select()
//                 .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
//                 .build();
                .apiInfo(apiInfo())
                .select()
                //扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                 .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Test  ")
                .title("基础平台 RESTful APIs")
                .description("基础平台 RESTful 风格的接口文档，内容详细极大的减少了前后端的沟通成本，同时确保代码与文档保持高度一致，极大的减少维护文档的时间。")
                .termsOfServiceUrl("http://xiachengwei5.coding.me")
                .contact("Sean.Wan")
//                 .license("个人博客")
//                 .licenseUrl("http://xiachengwei5.coding.me")
                .version("1.0")
                .build();
    }
}
