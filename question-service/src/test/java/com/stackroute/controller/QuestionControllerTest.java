package com.stackroute.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Questions;
import com.stackroute.service.QuestionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    private Questions question;
    List<Questions> listOfQuestion=new ArrayList<>();

    @Autowired
    private MockMvc mockMvc;

    @Mock
    QuestionServiceImpl questionService;

    @Mock
    KafkaTemplate<String, Questions> kafkaTemplate;

    @InjectMocks
    QuestionController questionController;

    @Before
    public void setUp()throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
        question=new Questions(0,"Awesome" ,"Question1","input Format","output Format","Beginner","java","url","abc");
        listOfQuestion.add(question);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when( questionService.saveQuestion(question)).thenReturn(question);
        mockMvc.perform(post("/api/v1/question").contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)
                .content(jsonToString(question)))
                .andExpect(status().isOk());
        verify(questionService,times(1)).saveQuestion(Mockito.any(Questions.class));
        verifyNoMoreInteractions(questionService);
    }

    @Test
    public void testGetQuestion() throws Exception{
        int id=0;
        when( questionService.getQuestionById(id)).thenReturn(question);
        mockMvc.perform(get("/api/v1/question/{id}",0)).andExpect(status().isOk());
        verify(questionService,times(1)).getQuestionById(id);
        verifyNoMoreInteractions(questionService);
    }

    @Test
    public void testGetQuestions() throws Exception{
        String tagValue = "java";
        when( questionService.getQuestionByTag(tagValue)).thenReturn(listOfQuestion);
        mockMvc.perform(get("/api/v1/questions/{tag}","java")).andExpect(status().isOk());
        verify(questionService,times(1)).getQuestionByTag(tagValue);
        verifyNoMoreInteractions(questionService);
    }

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