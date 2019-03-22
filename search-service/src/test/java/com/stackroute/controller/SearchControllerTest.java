//package com.stackroute.controller;
//
//import com.stackroute.domain.Question;
//import org.aspectj.lang.annotation.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.ExpectedCount.times;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class SearchControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private String  tags;
//    private List<Question> ques =  new ArrayList<>();
//
//
//    @Mock
//    private Question question;
//
//    @InjectMocks
//    private QuestionController questionController;
//
////    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
//    }
//}
//
