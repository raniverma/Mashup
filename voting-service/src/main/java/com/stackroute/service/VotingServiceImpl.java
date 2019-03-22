package com.stackroute.service;

import com.stackroute.domain.Vote;
import com.stackroute.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl implements VotingService{

    VoteRepository voteRepository;

    @Autowired
    public VotingServiceImpl(VoteRepository voteRepository){
        this.voteRepository=voteRepository;
    }

    @Override
    public List<Vote> upVotesForAQuestion(int questionId){
        return voteRepository.fetchUpForQuestion(questionId);
    }

    @Override
    public List<Vote> downVotesForAQuestion(int questionId){
        return voteRepository.fetchDownForQuestion(questionId);
    }

    @Override
    public List<Vote> listOfQuestionsByUser(String userName){
        return voteRepository.fetchQuestionsByUser(userName);
    }

    @Override
    public List<Vote> voteStatusOfQuestionByUser(int questionId,String userName){
        return voteRepository.fetchQuestionVoteStatus(questionId, userName);
    }
    @Override
    public Vote saveVoteForQuestion(Vote vote){
        return voteRepository.saveVoteStatus(vote);
    }


}
