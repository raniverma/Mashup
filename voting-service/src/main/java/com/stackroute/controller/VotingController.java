package com.stackroute.controller;


import com.stackroute.domain.Vote;
import com.stackroute.repository.VoteRepository;
import com.stackroute.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
@CrossOrigin("*")
public class VotingController {

    @Autowired
    private VotingService votingService;
    @Autowired
    private VoteRepository voteRepository;

    @GetMapping(value = "upvoted/{questionId}")
    public ResponseEntity<?> findNumberOfUpVotes(@PathVariable(value = "questionId") String questionId) {
        ResponseEntity responseEntity;
        int a = Integer.parseInt(questionId);
        List<Vote> upVotes=votingService.upVotesForAQuestion(a);
        responseEntity=new ResponseEntity<List<Vote>>(upVotes, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "downvoted/{questionId}")
    public ResponseEntity<?> findNumberOfDownVotes(@PathVariable(value = "questionId") String questionId) {
        ResponseEntity responseEntity;
        int a = Integer.parseInt(questionId);
        List<Vote> downVotes=votingService.downVotesForAQuestion(a);
        responseEntity=new ResponseEntity<List<Vote>>(downVotes, HttpStatus.OK);

        return responseEntity;
    }


    @GetMapping(value = "listvoted/{userName}")
    public ResponseEntity<?> questionsVotedByUser(@PathVariable(value = "userName") String userName) {
        ResponseEntity responseEntity;
        List<Vote> list=votingService.listOfQuestionsByUser(userName);
        responseEntity=new ResponseEntity<List<Vote>>(list, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "votestatus/{questionId}/{userName}")
    public ResponseEntity<?> voteStatus(@PathVariable(value = "questionId") String questionId,@PathVariable(value = "userName") String userName) {
        ResponseEntity responseEntity;
        int a = Integer.parseInt(questionId);
        List<Vote> downVotes=votingService.voteStatusOfQuestionByUser(a,userName);
        responseEntity=new ResponseEntity<List<Vote>>(downVotes, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping(value = "vote")
    public ResponseEntity<?> saveVoted(@RequestBody Vote vote){
        ResponseEntity responseEntity;
        Vote status = votingService.saveVoteForQuestion(vote);
        responseEntity = new ResponseEntity<Vote>(status,HttpStatus.ACCEPTED);
        return responseEntity;
    }

}
