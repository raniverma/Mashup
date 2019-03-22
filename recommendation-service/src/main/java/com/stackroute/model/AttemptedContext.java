package com.stackroute.model;

public class AttemptedContext {

    private User user;
    private Question question;

    public AttemptedContext() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
