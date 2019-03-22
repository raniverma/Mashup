package com.stackroute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class QuestionTagInfo {


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    @Field
    String tagName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Id
      String _id;
    String username;
    @Field
    int totalQuestions;
    @Field
    double totalEasyPoints;
    @Field
    double totalMediumPoints;
    @Field
    double totalHardPoints;
    @Field
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    String ratio;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String levelRatio;



    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public double getTotalEasyPoints() {
        return totalEasyPoints;
    }

    public void setTotalEasyPoints(double totalEasyPoints) {
        this.totalEasyPoints = totalEasyPoints;
    }

    public double getTotalMediumPoints() {
        return totalMediumPoints;
    }

    public void setTotalMediumPoints(double totalMediumPoints) {
        this.totalMediumPoints = totalMediumPoints;
    }

    public double getTotalHardPoints() {
        return totalHardPoints;
    }

    public void setTotalHardPoints(double totalHardPoints) {
        this.totalHardPoints = totalHardPoints;
    }

    public String getLevelRatio() {
        return levelRatio;
    }

    public void setLevelRatio(String levelRatio) {
        levelRatio = levelRatio;
    }




}
