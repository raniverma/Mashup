package com.stackroute.service;

import com.stackroute.domain.Questions;
import com.stackroute.exceptions.QuestionAlreadyExistsException;
import com.stackroute.exceptions.QuestionNotPresentException;

import java.util.List;

/*question service interface*/
public interface QuestionService {

    //method to save question
    Questions saveQuestion(Questions question) throws QuestionAlreadyExistsException;

    //method to get question by Id
    Questions getQuestionById(int id) throws QuestionNotPresentException;

    //method to get question objects by tag
    List<Questions> getQuestionByTag(String tag) throws QuestionNotPresentException;
}
