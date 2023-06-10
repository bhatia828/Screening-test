package com.SampleProject.Entity;

import com.SampleProject.QuestionDto.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NextQuestionResponse {

    private String correct_Answer;

    private QuestionDto next_Question;
}
