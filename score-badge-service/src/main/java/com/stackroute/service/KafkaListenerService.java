package com.stackroute.service;

import com.stackroute.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*Service for kafka*/
@Service
public class KafkaListenerService {

    public ScoreAndBadgeService scoreAndBadgeService;

    @Autowired
    public KafkaListenerService(ScoreAndBadgeService scoreAndBadgeService) {
        this.scoreAndBadgeService = scoreAndBadgeService;
    }

    @KafkaListener(topics = "SubmissionMessage", groupId = "group_id_score")
    public void consume(String message)
    {
        System.out.println("Consumed msg : " + message);
        Score score=new Score();
        String submitValues[] = message.trim().split(",");
        String submittedusername[] = submitValues[1].trim().split(":");
        String scoreVal[] = submitValues[9].trim().split(":");
        String userName =submittedusername[1].trim().replace("\"", "");
        score.setUserName(userName);
        double scoreOfQuestion=Double.parseDouble(scoreVal[1].trim().replace("}",""));
        //method to store username and calculate total score
        scoreAndBadgeService.calcAndUpdateTotalScore(score,scoreOfQuestion);
    }
    @KafkaListener(topics = "AuthMessage", groupId = "group_id_score")
    public void consume1(String message1)
    {
        System.out.println("Consumed msg : " + message1);
        Score score=new Score();
        String splittedData[] =  message1.trim().split(",");
        String submitteduserdata[] = splittedData[0].trim().split(":");
        String registeredUserName = submitteduserdata[1].trim().replace("\"","");
        score.setUserName(registeredUserName);
        score.setTotalScore(0.0);
        scoreAndBadgeService.saveTotalScore(score);
    }
}
