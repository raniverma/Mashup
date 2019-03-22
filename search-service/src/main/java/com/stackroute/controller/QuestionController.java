package com.stackroute.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.stackroute.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")
@RefreshScope
@RestController
@RequestMapping(value = "/api/v1/")
public class QuestionController {

    private RestTemplate restTemplate;
    private EurekaClient eurekaClient;

    private List<Question> ques;

    @Autowired
    public QuestionController(RestTemplate restTemplate, EurekaClient eurekaClient) {
        this.restTemplate = restTemplate;
        this.eurekaClient = eurekaClient;
    }

//       request method to call question service controller
    @RequestMapping(value = "question/{tag}")
    public List<Question> getQuestionByTag(@PathVariable String tag) {
        Application application = eurekaClient.getApplication("QUESTION-SERVICE");
        System.out.println("App : " + application);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        System.out.println("Inst : " + instanceInfo);
        String url = "http://" + "localhost" + ":" + instanceInfo.getPort() + "/" + "api/v1/questions/" + tag;
        System.out.println("URL" + url);
        List<Question> ques = restTemplate.getForObject(url, List.class);
        System.out.println("RESPONSE " + ques);
        this.ques = ques;
        return this.ques;
    }

    @GetMapping(value = "searched")
    public List<Question> giveQuestions(){
        return ques;
    }
}