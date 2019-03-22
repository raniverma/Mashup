package com.stackroute.repository;

import com.stackroute.domain.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*question repository interface*/
public interface QuestionRepository extends MongoRepository<Questions, Integer>, QuestionRepositoryCustom {

    public List<Questions> findByTags(String tag);
    public Questions findByQuestionId(int id);

}
