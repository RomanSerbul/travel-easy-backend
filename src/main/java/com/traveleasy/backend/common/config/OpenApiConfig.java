package com.traveleasy.backend.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${app.url:https://api.easy-travel.com.ua}")
    private String appUrl;

    @Bean
    public OpenAPI travelEasyOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Travel Easy API")
                        .description("Backend services for the Travel Easy booking platform")
                        .version("v0.1"))
                .servers(List.of(
                        new Server().url(appUrl).description("Production"),
                        new Server().url("http://localhost:8081").description("Local Development")
                ))
                .components(new Components().addSecuritySchemes("basicAuth",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }
}
