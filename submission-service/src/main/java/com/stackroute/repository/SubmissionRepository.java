package com.stackroute.repository;

import com.stackroute.domain.SubmissionData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends MongoRepository<SubmissionData, String> {

    // Method to get submission data from database using username and questionID
    List<SubmissionData> getSubmissionDataByUsernameAndQuestionId(String username, int questionId);
}
