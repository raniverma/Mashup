package com.stackroute.controller;
import com.stackroute.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/")
@CrossOrigin(value = "*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
    @RequestMapping(value = "code", method = RequestMethod.POST)
    public ResponseEntity<String> saveTrack(@RequestBody String code) throws Exception {
        ResponseEntity responseEntity;
        String code1= questionService.run(code);
        responseEntity=new ResponseEntity<String>(code1, HttpStatus.CREATED);
        return responseEntity;
    }


}