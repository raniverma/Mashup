package com.stackroute.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.config.KafkaConfiguration;
import com.stackroute.controller.UserController;
import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.service.UserService;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.concurrent.ListenableFuture;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegistrationControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService service;

    @Mock
    private KafkaConfiguration configuration;

    //@Mock
    private KafkaTemplate<String, User> template;


    User user;
    List<User> userList;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setUsername("mahe12");
        user.setPassword("blowin in the wind");
        user.setGender("Nice song");
        user.setLastName("mahe12");
        user.setFirstName("blowin in the wind");
        user.setEmailId("Nice song");
        user.setCourse("mahe12");
        user.setDiscipline("blowin in the wind");
        user.setCollege("Nice song");
        user.setAge(25);
        user.setInterest("blowin in the wind");
        user.setCompany("Nice song");

        userList = new ArrayList<User>();
        userList.add(user);

    }


    @Test
    public void listallUsers_success(){
        Mockito.when(service.getAllUsers()).thenReturn(userList);
        ResponseEntity result = userController.listOfUsers();
        verify(service).getAllUsers();
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

    @Test
    public void deleteUser_sucess() throws UserNotFoundException {
        Mockito.when(service.deleteUser("User")).thenReturn(user);
        ResponseEntity result = userController.deleteUser("User");
        verify(service).deleteUser("User");
        Assert.assertEquals(HttpStatus.GONE,result.getStatusCode());
    }

    @Test
    public void UpdateUser_success() throws UserNotFoundException {
        Mockito.when(service.updateUser("User",user)).thenReturn(user);
        ResponseEntity result = userController.updateUser("User",user);
        verify(service).updateUser("User",user);
        Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
    }

}
