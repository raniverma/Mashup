package com.stackroute.repository;

import com.stackroute.domain.Vote;

import java.util.List;

public interface VoteRepositoryCustom {

    public List<Vote> fetchUpForQuestion(int questionId);

    public List<Vote> fetchDownForQuestion(int questionId);

    public List<Vote> fetchQuestionsByUser(String userName);

    public List<Vote> fetchQuestionVoteStatus(int questionId,String userName);

    public Vote saveVoteStatus(Vote vote);

}
