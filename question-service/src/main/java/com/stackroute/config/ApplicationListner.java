package com.stackroute.config;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stackroute.domain.Counters;
import com.stackroute.domain.Questions;
import com.stackroute.repository.CounterRepository;
import com.stackroute.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;

/*class to add seed data on start of application*/
@Component
public class ApplicationListner implements ApplicationListener<ApplicationReadyEvent> {

    private QuestionRepository questionRepository;
    private CounterRepository counterRepository;

    private String fileName;

    @Autowired
    public ApplicationListner(QuestionRepository questionRepository, CounterRepository counterRepository) {
        this.questionRepository = questionRepository;
        this.counterRepository = counterRepository;
        fileName = "/DB/resources/csvRepoUpdated.csv";
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent){
        seedData();
    }

    /*method to push seed data */
    public void seedData()  {
        counterRepository.deleteAll();
        counterRepository.save(new Counters("questionId", 51));
        questionRepository.deleteAll();
        questionRepository.save(new Questions(0,"Awesome" ,"Question1","input format","output Format","Beginner","java","url","abc"));
        File file = new File(fileName);
        try{
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build();
            String[] record;
            Questions question;
            while ((record = csvReader.readNext()) != null) {
                question = new Questions();
                question.setQuestionId(Integer.parseInt(record[0]));
                question.setQuestionTitle(record[1]);
                question.setQuestionDescription(record[2]);
                question.setInputFormat(record[3]);
                question.setOutputFormat(record[4]);
                question.setDifficulty(record[5]);
                question.setTags(record[6].toLowerCase());
                question.setGitUrl(record[7]);
                question.setUsername("admin");
                if (!questionRepository.existsById(Integer.parseInt(record[0]))) {
                    questionRepository.save(question);
                }
            }
        }
        catch (Exception e){
        }
    }
}
