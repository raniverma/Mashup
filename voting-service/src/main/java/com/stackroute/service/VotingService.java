package com.stackroute.service;

import com.stackroute.domain.Vote;

import java.util.List;

public interface VotingService {

    public List<Vote> upVotesForAQuestion(int questionId);
    public List<Vote> downVotesForAQuestion(int questionId);
    public Vote saveVoteForQuestion(Vote vote);
    public List<Vote> listOfQuestionsByUser(String userName);
    public List<Vote> voteStatusOfQuestionByUser(int questionId,String userName);


}
