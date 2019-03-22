package com.stackroute.controller;
import com.stackroute.domain.Score;
import com.stackroute.service.ScoreAndBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



//Main controller
/*Controller class*/
@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/")
public class ScoreAndBadgeController {

    private ScoreAndBadgeService scoreAndBadgeService;

    @Autowired
    public ScoreAndBadgeController(ScoreAndBadgeService scoreAndBadgeService) {
        this.scoreAndBadgeService = scoreAndBadgeService;
    }

    //method to get User Data
    @GetMapping("getTotalScore/{userName}")
    public ResponseEntity<?> getTotalScoreController(@PathVariable(value = "userName") String userName){
        Score score = new Score();
        score = scoreAndBadgeService.getTotalScore(userName);
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

}
