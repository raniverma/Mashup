package com.stackroute.repository;

import com.stackroute.domain.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreRepository extends MongoRepository<Score,String>{

}
