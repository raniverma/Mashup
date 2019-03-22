package com.stackroute.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.controllers.SubmissionController;
import com.stackroute.domain.SubmissionData;
import com.stackroute.service.SubmissionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SubmissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SubmissionService submissionService;

    @InjectMocks
    private SubmissionController submissionController;

    private SubmissionData submissionData;
    private List<SubmissionData> submissionDataList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(submissionController).build();
        submissionData = new SubmissionData();
        submissionData.setUsername("Admin");
        submissionData.setQuestionId(1);
        submissionData.setQuestionTitle("First Question");
        submissionData.setResult("Success");
        submissionData.setDifficulty("easy");
        submissionData.setTestCasePassed(10);
        submissionData.setTotalTestCases(10);
        submissionData.setSolution("No Solution available");
        submissionDataList.add(submissionData);
        submissionData = new SubmissionData();
        submissionData.setUsername("Admin");
        submissionData.setQuestionId(1);
        submissionData.setQuestionTitle("Second Question");
        submissionData.setResult("Success");
        submissionData.setDifficulty("easy");
        submissionData.setTestCasePassed(10);
        submissionData.setTotalTestCases(10);
        submissionData.setSolution("No Solution available");
        submissionDataList.add(submissionData);
        submissionData = new SubmissionData();
        submissionData.setUsername("Admin");
        submissionData.setQuestionId(1);
        submissionData.setQuestionTitle("Third Question");
        submissionData.setResult("Success");
        submissionData.setDifficulty("easy");
        submissionData.setTestCasePassed(10);
        submissionData.setTotalTestCases(10);
        submissionData.setSolution("No Solution available");
        submissionDataList.add(submissionData);
        submissionData = new SubmissionData();
        submissionData.setUsername("Admin");
        submissionData.setQuestionId(1);
        submissionData.setQuestionTitle("Fourth Question");
        submissionData.setResult("Success");
        submissionData.setDifficulty("easy");
        submissionData.setTestCasePassed(10);
        submissionData.setTotalTestCases(10);
        submissionData.setSolution("No Solution available");
        submissionDataList.add(submissionData);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveSubmission() throws Exception{
        mockMvc.perform(post("/api/v1/submission")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(submissionData)))
                .andExpect(status().isOk());
        verify(submissionService, times(1)).saveSubmission(Mockito.any(SubmissionData.class));
        verifyNoMoreInteractions(submissionService);
    }

    @Test
    public void getSubmissions() throws Exception{
        when(submissionService.getSubmission("Kishlay",1)).thenReturn(submissionDataList);
        mockMvc.perform(get("/api/v1/submission/Kishlay/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(submissionService, times(1)).getSubmission("Kishlay",1);
        verifyNoMoreInteractions(submissionService);
    }

    // method to convert Json to string
    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {

            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;

    }
}
