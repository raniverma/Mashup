package com.stackroute.config;
import com.stackroute.domain.Score;
import com.stackroute.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*class to add seed data on start of application*/
@Component
public class ApplicationListner implements ApplicationListener<ApplicationReadyEvent>  {

    private ScoreRepository scoreRepository;


    @Autowired
    public ApplicationListner(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }


    @Override
     public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        seedData();
     }

    /*method to push seed data */
    public void seedData(){
        scoreRepository.delete(new Score("ram",0.0));
        scoreRepository.save(new Score("ram",0.0));
    }
}
