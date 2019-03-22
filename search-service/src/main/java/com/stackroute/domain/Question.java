package com.stackroute.domain;

public class Question {
//    defining field variables for question class
    private String tag;
    private String questionDescription;
    public int questionId;
    private String questionTitle;
    private String  inputFormat;
    private String outputFormat;
    private String difficulty;
    private String gitUrl;

    public Question(String tag, String questiondescription) {
        this.tag = tag;
        this.questionDescription = questiondescription;
    }
}
