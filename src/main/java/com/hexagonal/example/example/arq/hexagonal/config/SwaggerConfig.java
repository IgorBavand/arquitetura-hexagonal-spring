package com.hexagonal.example.example.arq.hexagonal.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String DESCRICAO = "Documentação da aplicação exemplo para arquitetura hexagonal.";
    private static final String URL = "localhost:8080";
    private static final String GRUPO_ADMIN = "admin";
    private static final String PATHS_GRUPO_ADMIN = "/**";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/docs", "/swagger-ui.html");
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group(GRUPO_ADMIN)
                .pathsToMatch(PATHS_GRUPO_ADMIN)
                .build();
    }

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
                .info(new Info().title("arquitetura hexagonal")
                        .description(DESCRICAO)
                        .version("0.1")
                        .license(new License().url(URL)));
    }

}