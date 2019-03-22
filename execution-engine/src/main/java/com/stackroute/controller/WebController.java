package com.stackroute.controller;
import  org.springframework.messaging.simp.SimpMessagingTemplate;
import com.stackroute.domain.Code;
import com.stackroute.domain.User;
//import com.stackroute.service.QuestionService;
import com.stackroute.service.ResultsService;
//import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class WebController {

    public ResultsService getResultsService() {
        return resultsService;
    }
    @Autowired
    private SimpMessagingTemplate template;

    public void setResultsService(ResultsService resultsService) {
        this.resultsService = resultsService;
    }

    @Autowired
    private ResultsService resultsService;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
        String response=this.resultsService.run(user.getName());
        this.template.convertAndSend("/topic",new Code(response));

    }
}
