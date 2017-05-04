package io.egens.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//localhost:8080/spring-rest/api/v2/api-docs to run in postman
    //copy this from https://github.com/springfox/springfox-demos/blob/master/spring-java-swagger/src/main/java/springfoxdemo/java/swagger/SpringConfig.java
//run now on http://localhost:8080/spring-rest/swagger-ui.html
}

