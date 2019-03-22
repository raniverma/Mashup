package com.stackroute.service;

import com.mongodb.*;
import com.stackroute.domain.Questions;
import com.stackroute.exceptions.QuestionAlreadyExistsException;
import com.stackroute.exceptions.QuestionNotPresentException;
import com.stackroute.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.BasicDBObject;
import java.util.List;

/*Question Service Implementation class*/
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;


    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository=questionRepository;
    }


    /*save method to save questions*/
    @Override
    public Questions saveQuestion(Questions question) throws QuestionAlreadyExistsException{
        BasicDBObject document = new BasicDBObject();
        document.put("Id", getNextSequence("questionId"));
        question.setQuestionId((int)document.get("Id")+1);

        if(questionRepository.existsById((int)(question.getQuestionId()))) {
            throw new QuestionAlreadyExistsException("This Question already exists");
        }
        String tag=question.getTags().toLowerCase();
        question.setTags(tag);
        //save call of repository
        return questionRepository.save(question);
    }

    /*method for incrementing sequence value*/
    public static Object getNextSequence(String name){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("mashup");
        DBCollection collection = db.getCollection("counters");
        BasicDBObject find = new BasicDBObject();
        BasicDBObject update = new BasicDBObject();
        update.put("$inc", new BasicDBObject("seq", 1));
        DBObject obj = collection.findAndModify(find, update);
        return obj.get("seq");
    }

    /*method to get question by questionId*/
    @Override
    public Questions getQuestionById(int id) throws QuestionNotPresentException {
        if(questionRepository.findByQuestionId(id)==null){
            throw new QuestionNotPresentException("Question is not present in database");
        }
        return questionRepository.getById(id);
    }

    /*method to get questions by tag*/
    @Override
    public List<Questions> getQuestionByTag(String tag) throws QuestionNotPresentException {
        if(questionRepository.findByTags(tag).size()==0) {
            throw new QuestionNotPresentException("Question of this tag are not present in database");
        }
        return questionRepository.getByTag(tag);
    }

}
