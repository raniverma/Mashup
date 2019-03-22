package com.stackroute.controller;


import com.stackroute.model.Question;
import com.stackroute.model.SubmissionDetails;
import com.stackroute.model.User;
import com.stackroute.service.QuestionTagInfoService;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/")
@CrossOrigin("*")
public class UserResourcecontroller {

    @Autowired
    public UserService userService;
    @Autowired
    public QuestionTagInfoService tagInfoService;

    public UserResourcecontroller(UserService  userService,QuestionTagInfoService tagInfoService) {
    this.userService=userService;
    this.tagInfoService=tagInfoService;
    }

    @PostMapping(value = "submission")
    public void submissiontagChanges(@RequestBody SubmissionDetails submissionDetails) {
       System.out.println(submissionDetails.getQuestionId());
        if(submissionDetails==null||submissionDetails.getScore()==null||submissionDetails.getUsername()==null)
            return ;
        System.out.println(submissionDetails.getQuestionId()+submissionDetails.getUsername()+submissionDetails.getScore());
        tagInfoService.addOrUpdateTag(submissionDetails.getQuestionId(),submissionDetails.getScore(),submissionDetails.getUsername());

    }

    @PostMapping(value = "saveQuestion")
    public void postQuestions(@RequestBody Question question) {
              tagInfoService.saveQuestion(question);


    }

    @GetMapping(value = "userQuestions")
    public List<Question> getUserQuestions(@RequestBody User user) {
        if(user==null||user.getUsername()==null)
            return null;

        return tagInfoService.getUserQuestions(user.getUsername());
    }


   @DeleteMapping(value="deleteUser")
     public ResponseEntity<?> deleteUser(@RequestBody User user) {
       if(user==null||user.getUsername()==null)
           return null;
         ResponseEntity responseEntity;
         userService.deleteUser(user);
         responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);

         return responseEntity;
     }

    @PostMapping(value = "registration")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        if(user==null||user.getUsername()==null)
            return null;
      ResponseEntity responseEntity;

        User user1 = userService.createUserNode(user);
        tagInfoService.addTags(user.getTags(),user.getUsername());
        responseEntity = new ResponseEntity<User>(user1, HttpStatus.CREATED);

        return responseEntity;
    }

    @PostMapping(value = "addInterests")
    public ResponseEntity<?> addInterest(@RequestBody User user) {
        if(user==null||user.getUsername()==null||user.getTags()==null)
            return null;
        ResponseEntity responseEntity;
         tagInfoService.addTags(user.getTags(),user.getUsername());
        responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping(value = "questions/{username}")
    public List<Question> getAllQuestions(@PathVariable String username) {
        if(username==null || username.equals("null")){
            return userService.getAllQuestions();
        }
        else
            return tagInfoService.getUserQuestions(username);
    }

}


