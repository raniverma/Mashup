package com.stackroute.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vote {

    private Integer questionId;
    private String userName;
    private String voteStatus;

    public Vote() {
    }

    public Vote(String userName, Integer questionId, String voteStatus) {
        this.userName = userName;
        this.questionId = questionId;
        this.voteStatus = voteStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(String voteStatus) {
        this.voteStatus = voteStatus;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "userName='" + userName + '\'' +
                ", questionId=" + questionId +
                ", voteStatus='" + voteStatus + '\'' +
                '}';
    }
}

