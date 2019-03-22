package com.stackroute.repository;

import com.stackroute.domain.Questions;

import java.util.List;

public interface QuestionRepositoryCustom {

    //for querying get by questionId
    public Questions getById(int questionId);

    //for querying get by tag
    public List<Questions> getByTag(String tag);
}
