package com.stackroute.repository;

import com.stackroute.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class VoteRepositoryImpl implements VoteRepositoryCustom {

    private final MongoOperations operations;

    @Autowired
    public VoteRepositoryImpl(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<Vote> fetchUpForQuestion(int questionId){
        Query query  = new Query();
        query.addCriteria(Criteria.where("questionId").is(questionId));
        query.addCriteria(Criteria.where("voteStatus").is("UP"));
        List<Vote> people = operations.find(query,Vote.class);
        return people;
    }

    @Override
    public List<Vote> fetchDownForQuestion(int questionId){
        Query query = new Query();
        query.addCriteria(Criteria.where("questionId").is(questionId));
        query.addCriteria(Criteria.where("voteStatus").is("DOWN"));
        List<Vote> people = operations.find(query,Vote.class);
        return people;
    }

    @Override
    public List<Vote> fetchQuestionsByUser(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        List<Vote> people = operations.find(query,Vote.class);
        return people;
    }

    @Override
    public List<Vote> fetchQuestionVoteStatus(int questionId,String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("questionId").is(questionId));
        query.addCriteria(Criteria.where("userName").is(userName));
        List<Vote> people = operations.find(query,Vote.class);
        return people;
    }

    @Override
    public Vote saveVoteStatus(Vote vote){
        operations.save(vote);
        return vote;
    }

}
