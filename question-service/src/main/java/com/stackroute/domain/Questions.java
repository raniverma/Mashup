package com.stackroute.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Data
@Document(collection="questions")
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
/*Question entity class for storing question information*/
public class Questions{
    @Id
    public int questionId;
    @Field
    private String questionTitle;
    @Field
    private String  questionDescription;
    @Field
    private String  inputFormat;
    @Field
    private String outputFormat;
    @Field
    private String difficulty;
    @Field
    private String tags;
    @Field
    private String gitUrl;
    @Field
    private String username;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Questions() {
    }

    public Questions(int questionId, String questionTitle, String questionDescription, String inputFormat, String outputFormat, String difficulty, String tags, String gitUrl, String username) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.difficulty = difficulty;
        this.tags = tags;
        this.gitUrl = gitUrl;
        this.username = username;
    }
    public Questions(int questionId, String questionTitle, String questionDescription, String inputFormat, String outputFormat, String difficulty, String tags, String gitUrl) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionDescription = questionDescription;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.difficulty = difficulty;
        this.tags = tags;
        this.gitUrl = gitUrl;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
