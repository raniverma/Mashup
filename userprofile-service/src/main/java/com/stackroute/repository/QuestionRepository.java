package com.stackroute.repository;

import org.springframework.stereotype.Repository;
import com.stackroute.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

// repository for question
@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {
}
