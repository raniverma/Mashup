package com.stackroute.model;

public class SubmissionScoreDetails {

    private String questiontag;
    private double  maxscore;
    private double score;
    private String level;
    private String username;

    public SubmissionScoreDetails(String questiontag, double maxscore, double score, String level, String username) {
        this.questiontag = questiontag;
        this.maxscore = maxscore;
        this.score = score;
        this.level = level;
        this.username = username;
    }

    public SubmissionScoreDetails() {
    }

    public String getQuestiontag() {
        return questiontag;
    }

    public void setQuestiontag(String questiontag) {
        this.questiontag = questiontag;
    }

    public double getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(double maxscore) {
        this.maxscore = maxscore;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String  getLevel() {
        return level;
    }

    public void setLevel(String  level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
