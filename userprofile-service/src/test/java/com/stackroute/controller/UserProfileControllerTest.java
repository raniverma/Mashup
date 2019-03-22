package com.stackroute.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Question;
import com.stackroute.domain.UserProfile;
import com.stackroute.service.UserDBProfileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private UserProfile userProfile;
    private List<String> interests= new ArrayList<>();
    private List<Question> questionAttempted = new ArrayList<>();
    private List<Question> questionPosted = new ArrayList<>();

    @Mock
    private UserDBProfileServiceImpl userDBProfileService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        interests.add("i1");
        interests.add("i2");
        interests.add("i3");
        Question question = new Question(1, "q1");
        questionAttempted.add(question);
        question = new Question(2, "q2");
        questionAttempted.add(question);
        question = new Question(1, "q1");
        questionPosted.add(question);
        question = new Question(2, "q2");
        questionPosted.add(question);
        userProfile = new UserProfile();
        userProfile.setUserName("ujj");
        userProfile.setFirstName("ujj");
        userProfile.setLastName("yati");
        userProfile.setPassword("1234567890");
        userProfile.setEmailId("u@gmail.com");
        userProfile.setInterests(interests);
        userProfile.setAttemptedQuestion(questionAttempted);
        userProfile.setPostedQuestion(questionPosted);
    }

    @Test
    public void saveUserProfile() throws Exception{
        when(userDBProfileService.saveUserProfile(userProfile)).thenReturn(userProfile);
        mockMvc.perform(post("/api/v1/userprofile")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(userProfile)))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).saveUserProfile(userProfile);
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void getUserProfile() throws Exception {
        when(userDBProfileService.getUser("ujj")).thenReturn(userProfile);
        mockMvc.perform(get("/api/v1/userprofile/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(2)).getUser("ujj");
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void getInterests() throws Exception {
        when(userDBProfileService.getInterests("ujj")).thenReturn(interests);
        mockMvc.perform(get("/api/v1/interests/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).getInterests("ujj");
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void editInterests() throws Exception {
        interests.add("i4");
        when(userDBProfileService.editInterests("ujj", interests)).thenReturn(interests);
        mockMvc.perform(post("/api/v1/interests/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(interests)))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).editInterests("ujj", interests);
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void deleteUserProfile() throws Exception {
        when(userDBProfileService.deleteUser("ujj")).thenReturn(true);
        mockMvc.perform(delete("/api/v1/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).deleteUser("ujj");
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void updateQuestionAttempted() throws Exception {
        Question question = new Question(3, "q3");
        questionAttempted.add(question);
        when(userDBProfileService.updateQuestionAttempted("ujj", question)).thenReturn(userProfile);
        mockMvc.perform(post("/api/v1/questionattempted/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(question)))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).updateQuestionAttempted("ujj", question);
        verifyNoMoreInteractions(userDBProfileService);
    }

    @Test
    public void updateQuestionPosted() throws Exception {
        Question question = new Question(3, "q3");
        questionAttempted.add(question);
        when(userDBProfileService.updateQuestionPosted("ujj", question)).thenReturn(userProfile);
        mockMvc.perform(post("/api/v1/questionposted/ujj")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(question)))
                .andExpect(status().isOk());
        verify(userDBProfileService, times(1)).updateQuestionPosted("ujj", question);
        verifyNoMoreInteractions(userDBProfileService);
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