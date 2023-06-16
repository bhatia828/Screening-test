package com.SampleProject.Exception;


import com.SampleProject.Entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        ApiResponse apiResponse=new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>( apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LastDataBaseQuestion.class)
    public ResponseEntity<ApiResponse> LastDatabaseQuestionExceptionHandler(LastDataBaseQuestion ex){
        ApiResponse apiResponse=new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
