package com.stackroute.controller;

import com.stackroute.domain.Hello;
import com.stackroute.domain.User;
import com.stackroute.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(value = "*")
@Controller
public class WebController {

    @Autowired
    private QuestionService questionService;
    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic-js/hi")
    public Hello  greeting(User user) throws Exception {
        String response=this.questionService.run(user.getName());
        System.out.println(response);

        return new Hello(response);
    }
}
