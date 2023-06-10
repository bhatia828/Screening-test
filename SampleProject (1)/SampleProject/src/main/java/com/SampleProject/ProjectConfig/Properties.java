package com.SampleProject.ProjectConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Properties {

    @Value("${url.get-Question}")
    private String randomQuestionAPI;
}
