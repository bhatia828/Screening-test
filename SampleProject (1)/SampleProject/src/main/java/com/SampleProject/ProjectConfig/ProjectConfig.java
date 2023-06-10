package com.SampleProject.ProjectConfig;


import com.SampleProject.ProjectService.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {
    @Autowired
    private ProjectService projectService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() throws JsonProcessingException {
        projectService.getQuestions();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
