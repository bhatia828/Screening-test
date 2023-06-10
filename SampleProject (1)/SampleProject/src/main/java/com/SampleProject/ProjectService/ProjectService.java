package com.SampleProject.ProjectService;

import com.SampleProject.Entity.AnswerRequest;
import com.SampleProject.Entity.NextQuestionResponse;
import com.SampleProject.Entity.Question;

import com.SampleProject.ProjectConfig.Properties;
import com.SampleProject.ProjectRepo.ProjectRepo;
import com.SampleProject.QuestionDto.QuestionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.ToString;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

@Service
public class ProjectService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private QuestionDto questionDto;
    @Autowired
    private Properties properties;
    Question question;

    private static final Logger logger= LoggerFactory.getLogger(ProjectService.class);

    public void getQuestions(){
            for (int i = 0; i < 5; i++) {
                ResponseEntity<Question[]> responseEntity = restTemplate.getForEntity(properties.getRandomQuestionAPI(), Question[].class);
                if (responseEntity.getStatusCode().is2xxSuccessful()) {
                    Question[] questions=responseEntity.getBody();
                    if(questions!=null){
                        projectRepo.save(questions[0]);
                    }
                }
            }
    }
    private QuestionDto getRandomQuestion() {
        List<Question> allQuestions = projectRepo.findAll();
        int totalQuestion = allQuestions.size();
        if (totalQuestion == 0) {
            throw new RuntimeException("No questions available");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(totalQuestion);
        question=allQuestions.get(randomIndex);
        questionDto.setQuestion_id(question.getQuestionId());
        questionDto.setQuestion(question.getQuestion().toString());
        return questionDto;
    }


    public NextQuestionResponse getNext(AnswerRequest answerRequest) {
        Question currentQuestion = projectRepo.findById(answerRequest.getQuestion_id())
                .orElseThrow(() -> new RuntimeException("Question not found"));
        NextQuestionResponse response = new NextQuestionResponse(currentQuestion.getAnswer(),getRandomQuestion());
        return response;
    }

    public QuestionDto setDto() {
        return getRandomQuestion();
    }
}

