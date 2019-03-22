package com.stackroute.service;

import com.stackroute.domain.SubmissionData;
import com.stackroute.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService{

    private SubmissionRepository submissionRepository;
    private KafkaTemplate<String, SubmissionData> kafkaTemplate;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, KafkaTemplate<String, SubmissionData> kafkaTemplate) {
        this.submissionRepository = submissionRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    //Method to save the submission data into the database
    @Override
    public SubmissionData saveSubmission(SubmissionData submissionData) {
        double level;
        if(submissionData.getDifficulty().equals("Beginner")){
            level = 10;
        }
        else if(submissionData.getDifficulty().equals("Intermediate")){
            level = 20;
        }
        else{
            level = 30;
        }
        Double score1;
        if(submissionData.getTestCasePassed() == 0 || submissionData.getTotalTestCases() == 0){
            score1 = 0.0;
        }
        else{
            score1 = ((double)submissionData.getTestCasePassed()/(double)submissionData.getTotalTestCases())*level;
        }
        submissionData.setScore(score1);
        kafkaTemplate.send("SubmissionMessage",submissionData);
        return submissionRepository.save(submissionData);
    }

    //Method to fetch data on the basis of username and questionId from database
    @Override
    public List<SubmissionData> getSubmission(String username, int questionId) {
        return submissionRepository.getSubmissionDataByUsernameAndQuestionId(username,questionId);
    }
}
