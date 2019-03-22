package com.stackroute.service;
import com.stackroute.domain.Questions;
import com.stackroute.exceptions.QuestionAlreadyExistsException;
import com.stackroute.exceptions.QuestionNotPresentException;
import com.stackroute.repository.QuestionRepository;
import com.stackroute.repository.QuestionRepositoryCustom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(QuestionService.class)
public class QuestionServiceImplTest {

    private Questions question;
    List<Questions> listOfQuestion=new ArrayList<Questions>();

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionServiceImpl;

    Optional<Questions> options;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        question = new Questions(0,"Awesome" ,"Question1","input Format","output Format","Beginner","java","url","abc");
        listOfQuestion.add(question);
        options = Optional.of(question);
    }

    @Test
    public void testSaveMusicSuccess() throws QuestionAlreadyExistsException {
        when(questionRepository.save(question)).thenReturn(question);
        Questions questions= questionServiceImpl.saveQuestion(question);
        assertEquals(questions,question);
        verify(questionRepository, times(1)).save(question);
    }

}
