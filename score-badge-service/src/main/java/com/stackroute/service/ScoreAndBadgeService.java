package com.stackroute.service;

import com.stackroute.domain.Score;

/*question service interface*/
public interface ScoreAndBadgeService {

    Score calcAndUpdateTotalScore(Score score,double scoreOfQuestion);
    Score saveTotalScore(Score score);
    Score getTotalScore(String userName);
}
