package com.company.taskManager;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger implementation
 *
 * @author Miguel Company
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket tasksApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(taskPaths()).build();
    }

    private Predicate<String> taskPaths() {
        return or(regex("/tasks"),
                regex("/tasks/.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Task Manager API")
                .description("Task Manager API reference for developers")
                .contact("miguelcompanysoler@gmail.com").version("1.0").build();
    }
}
