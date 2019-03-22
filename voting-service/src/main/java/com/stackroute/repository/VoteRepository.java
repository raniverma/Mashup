package com.stackroute.repository;

import com.stackroute.domain.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VoteRepository extends MongoRepository<Vote,String>, VoteRepositoryCustom {


}
