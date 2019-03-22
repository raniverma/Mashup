package com.stackroute.controller;

import com.stackroute.domain.Questions;
import com.stackroute.exceptions.QuestionAlreadyExistsException;
import com.stackroute.exceptions.QuestionNotPresentException;
import com.stackroute.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*Controller class*/
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    KafkaTemplate<String, Questions> kafkaTemplate;

    /*post method for saving question*/
    @PostMapping("question")
    public ResponseEntity<String> saveQuestions(@RequestBody Questions question) {

        try {
            Questions question1 = questionService.saveQuestion(question);
            kafkaTemplate.send("QuestionMessage",question1);
            return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
        }
        catch(QuestionAlreadyExistsException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*get question object by Id*/
    @GetMapping("question/{questionId}")
    public ResponseEntity<?> getQuestion(@PathVariable(value = "questionId") int questionId){
        try{
            Questions question = questionService.getQuestionById(questionId);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        catch(QuestionNotPresentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*get question objects by tags*/
    @GetMapping("questions/{tag}")
    public ResponseEntity<?> getQuestions(@PathVariable(value = "tag") String tag){
        try{
            List<Questions> question = questionService.getQuestionByTag(tag);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        catch(QuestionNotPresentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
