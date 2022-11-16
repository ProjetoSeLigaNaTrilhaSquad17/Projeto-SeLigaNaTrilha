package com.unit17.seliganatrilha.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String AUTHORIZATION_KEY = "Authorization";

    @Bean
    public OpenAPI api() {

        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList(AUTHORIZATION_KEY);

        Components components = new Components();
        components.addSecuritySchemes(AUTHORIZATION_KEY,
                new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("Bearer")
                        .bearerFormat("JWT"));
        return new OpenAPI().components(components).addSecurityItem(securityRequirement);
    }
}
