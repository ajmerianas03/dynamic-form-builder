package com.dyform.dynamic_forms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dynamic Forms API")
                        .version("1.0")
                        .description("This is the API documentation for the Dynamic Forms application.")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
