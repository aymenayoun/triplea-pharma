package com.ayouni.tripleA.Pharma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
                registry.addMapping("/api/auth/**") // Adjust the path as needed
                        .allowedOrigins("http://localhost:4200") // Replace with your frontend's URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
