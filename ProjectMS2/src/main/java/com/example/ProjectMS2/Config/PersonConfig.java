package com.example.ProjectMS2.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PersonConfig {

    @Bean
    public RestTemplate CreateRestObject(){
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper CreateObjectMapper(){
        return new ObjectMapper();
    }
}

