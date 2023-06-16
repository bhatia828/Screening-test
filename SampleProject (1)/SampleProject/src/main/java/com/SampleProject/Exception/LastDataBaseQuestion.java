package com.SampleProject.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LastDataBaseQuestion extends RuntimeException{

    private String message;
}
