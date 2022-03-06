package com.zimug.boot.lanuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
//2 5 使用swagger建構API接口文檔
//需在啟動類加一個註解
@EnableWebMvc
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("boot lanunch 項目 API 文檔")
                .description("簡單優雅的restfun風格")
                .termsOfServiceUrl("http://www.zimug.com")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zimug.boot.lanuch"))
                .paths(regex("/rest/.*"))
                //2 5 使用swagger建構API接口文檔
                //.paths 不需要在 regex 前接 PathSelectors
                .build();
    }
}
