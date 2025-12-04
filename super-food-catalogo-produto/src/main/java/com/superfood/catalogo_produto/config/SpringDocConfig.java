package com.superfood.catalogo_produto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info().title("super-food-catalogo-produto-api")
                                .description("API para gerenciar o catálogo de produtos do ERP Super Food")
                                .version("1.0.0"));
    }
}
