package com.SampleProject.ProjectController;

import com.SampleProject.Entity.AnswerRequest;
import com.SampleProject.Entity.NextQuestionResponse;
import com.SampleProject.Entity.Question;
import com.SampleProject.ProjectService.ProjectService;
import com.SampleProject.QuestionDto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping(value="${api.path.question}")
    public QuestionDto getQuestion(){
        return projectService.setDto();
    }

    @PostMapping(value="${api.path.getNext}")
    public NextQuestionResponse next(@RequestBody AnswerRequest answerRequest) {
        return projectService.getNext(answerRequest);
    }
}
