package com.stackroute.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// POJO class for Question
@Document
@Data
@ApiModel(description = "All details about the Question. ")
public class Question {
    @Id
    @ApiModelProperty(notes = "The database generated question ID")
    private int questionId;
    @Field
    @ApiModelProperty(notes = "The questionTitle of track")
    private String questionTitle;
    
    // Constructors
    public Question() {}
    public Question(int questionId, String questionTitle) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
    }

    // setter and getter for fields
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
}
