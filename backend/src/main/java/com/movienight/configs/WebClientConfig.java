package com.movienight.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    @Bean
    public WebClient tmdbWebClient() {
        return WebClient.builder().baseUrl("https://api.themovied.org/3").build();

    }
}
