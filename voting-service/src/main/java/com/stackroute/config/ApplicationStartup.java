package com.stackroute.config;

import com.stackroute.repository.VoteRepository;
import com.stackroute.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:seed.properties")
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {


    @Value("${1userName}")
    private String userName1;
    @Value("${1questionId}")
    private int questionId1;
    @Value("${1voteStatus}")
    private String voteStatus1;

    @Value("${2userName}")
    private String userName2;
    @Value("${2questionId}")
    private int questionId2;
    @Value("${2voteStatus}")
    private String voteStatus2;





    @Autowired
    private VoteRepository voteRepository;


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        seedData();
    }

    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        voteRepository.save(new Vote(userName1,questionId1,voteStatus1));
        voteRepository.save(new Vote(userName2,questionId2,voteStatus2));
    }

}
