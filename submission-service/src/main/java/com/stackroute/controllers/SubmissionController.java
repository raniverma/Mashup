package com.stackroute.controllers;

import com.stackroute.domain.SubmissionData;
import com.stackroute.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class SubmissionController {

    private SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    //Method to post data into the database
    @PostMapping(value = "submission")
    public ResponseEntity<SubmissionData> saveSubmissions(@RequestBody SubmissionData submissionData){
        SubmissionData submissionData1 = submissionService.saveSubmission(submissionData);
        return new ResponseEntity<>(submissionData1, HttpStatus.OK);
    }

    //Method to fetch data(question) on the basis of username and questionId from database
    @GetMapping(value = "submission/{username}/{questionId}")
    public ResponseEntity<List<SubmissionData>> getSubmissions(@PathVariable("username") String username, @PathVariable("questionId") int questionId){
        List<SubmissionData> submissionData = submissionService.getSubmission(username,questionId);
        return new ResponseEntity<>(submissionData,HttpStatus.OK);
    }
}
