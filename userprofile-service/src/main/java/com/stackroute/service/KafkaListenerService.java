package com.stackroute.service;

import com.stackroute.domain.*;
import com.stackroute.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

// Service class to handle kafka Listener
@Service
public class KafkaListenerService {

    @Autowired
    UserProfileRepository userRepository;

    // consumer method for consuming object from registration service
    @KafkaListener(topics = "AuthMessage", groupId = "group_id_up")
    public void consume(String message){
        String [] strMessage = message.split(",");
        for(String str:strMessage){
            System.out.println(strMessage);
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(strMessage[6].split(":")[1].replace("\"",""));
        userProfile.setLastName(strMessage[7].split(":")[1].replace("\"",""));
        userProfile.setEmailId(strMessage[11].split(":")[1].replace("\"",""));
        userProfile.setUserName(strMessage[0].split(":")[1].replace("\"",""));
        userProfile.setPassword(strMessage[1].split(":")[1].replace("\"",""));
        userProfile.setAge(Integer.parseInt(strMessage[2].split(":")[1].replace("\"","")));
        userProfile.setGender(strMessage[3].split(":")[1].replace("\"",""));
        userProfile.setComapny(strMessage[4].split(":")[1].replace("\"",""));
        userProfile.setCourse(strMessage[5].split(":")[1].replace("\"",""));
        userProfile.setDiscipline(strMessage[9].split(":")[1].replace("\"",""));
        userProfile.setCollege(strMessage[12].split(":")[1].replace("\"",""));
        List<String> interest = new ArrayList<>();
        interest.add(strMessage[8].split(":")[1].replace("\"",""));
        userProfile.setInterests(interest);
        Question question = new Question(0, null);
        List<Question> attemptedQuestion = new ArrayList<>();
        attemptedQuestion.add(question);
        userProfile.setAttemptedQuestion(attemptedQuestion);
        List<Question> postedQuestion = new ArrayList<>();
        postedQuestion.add(question);
        userProfile.setPostedQuestion(postedQuestion);
        userRepository.save(userProfile);
    }
    
    // consumer method for consuming object from question service
    @KafkaListener(topics = "QuestionMessage", groupId = "group_id_up")
    public void consumeQuestion(String message){
        String[] strMessage = message.split(",\"");
        for(String str:strMessage){
            System.out.println(strMessage);
        }
        String userName = strMessage[8].split(":")[1].replace("\"","").replace("}","");
        Question question = new Question();
        question.setQuestionId(Integer.parseInt(strMessage[0].split(":")[1].replace("\"","")));
        question.setQuestionTitle(strMessage[1].split(":")[1].replace("\"",""));
        UserDBProfileServiceImpl userDBProfileService = new UserDBProfileServiceImpl(userRepository);
        userDBProfileService.updateQuestionPosted(userName, question);
    }

    // consumer method for consuming object from submission service
    @KafkaListener(topics = "SubmissionMessage", groupId = "group_id_up")
    public void consumeSubmission(String message){
        String[] strMessage = message.split(",");
        for(String str:strMessage){
            System.out.println(strMessage);
        }
        String userName = strMessage[1].split(":")[1].replace("\"","");
        Question question = new Question();
        question.setQuestionId(Integer.parseInt(strMessage[2].split(":")[1].replace("\"","")));
        question.setQuestionTitle(strMessage[3].split(":")[1].replace("\"",""));
        System.out.println("username: " + userName);
        System.out.println("qID: " + question.getQuestionId());
        System.out.println("qtitle: " + question.getQuestionTitle());
        UserDBProfileServiceImpl userDBProfileService = new UserDBProfileServiceImpl(userRepository);
        userDBProfileService.updateQuestionAttempted(userName, question);
    }
}
