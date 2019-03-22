package com.stackroute.service;

import com.stackroute.domain.Score;
import com.stackroute.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*Question Service Implementation class*/
@Service
public class ScoreAndBadgeServiceImpl implements ScoreAndBadgeService {

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreAndBadgeServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    //service method to calc and update data
    @Override
    public Score calcAndUpdateTotalScore(Score score,double scoreOfQuestion) {
        Score score1 = scoreRepository.findById(score.getUserName()).get();
        double totlScore = 0.0;
        totlScore = (score1.getTotalScore()+ scoreOfQuestion);
        score.setTotalScore(totlScore);
        scoreRepository.save(score);
        return score;
    }

    //service method to save data
    @Override
    public Score saveTotalScore(Score score){
        scoreRepository.save(score);
        System.out.println(score+"saved data in saveTotalScore");
        return score;
    }

    //service method to get data
    @Override
    public Score getTotalScore(String userName){
        Score score=new Score();
        score = scoreRepository.findById(userName).get();
        System.out.println(score + "score in get data");
        return score;
    }
}
