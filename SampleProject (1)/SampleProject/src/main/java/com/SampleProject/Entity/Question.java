package com.SampleProject.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="QuestionRecords")
@ToString
public class Question {

    @JsonProperty("id")
    @Id
    @Column(name="id")
    private int questionId;

    @JsonProperty("answer")
    @Column(name="answer")
    private String answer;

    @JsonProperty("question")
    @Column(name="question")
    private String question;

}
