package com.stackroute.service;

import com.stackroute.domain.SubmissionData;

import java.util.List;

public interface SubmissionService {
    public SubmissionData saveSubmission(SubmissionData submissionData);

    public List<SubmissionData> getSubmission(String username, int questionId);
}
