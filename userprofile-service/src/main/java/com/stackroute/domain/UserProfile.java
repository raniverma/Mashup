package com.stackroute.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

// POJO class for UserProfile
@Document(collection = "userprofile")
@Data
@ApiModel(description = "All details about the UserProfile. ")
public class UserProfile {
    // variable declaration
    @Id
    @ApiModelProperty(notes = "The userName of user")
    private String userName;
    @Field
    @ApiModelProperty(notes = "The firstName of user")
    private String firstName;
    @Field
    @ApiModelProperty(notes = "The lastName of user")
    private String lastName;
    @Field
    @ApiModelProperty(notes = "The password of user")
    private String password;
    @Field
    @ApiModelProperty(notes = "The emailId of user")
    private String emailId;
    @Field
    @ApiModelProperty(notes = "The age of user")
    private int age;
    @Field
    @ApiModelProperty(notes = "The gender of user")
    private String gender;
    @Field
    @ApiModelProperty(notes = "The user interests")
    private List<String> interests;
    @Field
    @ApiModelProperty(notes = "The company of user")
    private String company;
    @Field
    @ApiModelProperty(notes = "The course of user")
    private String course;
    @Field
    @ApiModelProperty(notes = "The discipline of user")
    private String discipline;
    @Field
    @ApiModelProperty(notes = "The college of user")
    private String college;
    @Field
    @ApiModelProperty(notes = "The user attemptedQuestion")
    private List<Question> attemptedQuestion;
    @Field
    @ApiModelProperty(notes = "The user postedQuestion")
    private List<Question> postedQuestion;

    // setter and getter for variables
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getComapny() {
        return company;
    }

    public void setComapny(String comapny) {
        this.company = comapny;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<Question> getAttemptedQuestion() {
        return attemptedQuestion;
    }

    public void setAttemptedQuestion(List<Question> attemptedQuestion) {
        this.attemptedQuestion = attemptedQuestion;
    }

    public List<Question> getPostedQuestion() {
        return postedQuestion;
    }

    public void setPostedQuestion(List<Question> postedQuestion) {
        this.postedQuestion = postedQuestion;
    }
}
