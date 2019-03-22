package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.UserProfile;
import com.stackroute.exception.UserProfileAlreadyExistException;
import com.stackroute.exception.UserProfileNotFoundException;
import com.stackroute.repository.UserProfileRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileDBServiceTest {
    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserDBProfileServiceImpl userDBProfileService;

    private UserProfile userProfile;
    private List<String> interests= new ArrayList<>();
    private List<Question> questionAttempted = new ArrayList<>();
    private List<Question> questionPosted = new ArrayList<>();
//    @Test
//    public void setTrackService() {
//    }

    @Before
    public void setUp() {
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
    public void saveUserProfile() throws UserProfileAlreadyExistException {
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        UserProfile actual = userDBProfileService.saveUserProfile(userProfile);
        assertEquals(userProfile, actual);
        verify(userProfileRepository, times(1)).save(userProfile);
    }

    @Test
    public void getUserProfile() throws UserProfileAlreadyExistException, UserProfileNotFoundException{
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        when(userProfileRepository.existsById("ujj")).thenReturn(true);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        UserProfile actual = userDBProfileService.getUser("ujj");
        assertEquals(userProfile.toString(), actual.toString());
    }

    @Test
    public void changePassword() throws UserProfileAlreadyExistException, UserProfileNotFoundException {
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        when(userProfileRepository.existsById("ujj")).thenReturn(true);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        UserProfile actual = userDBProfileService.changePassword("ujj","newpassword");
        userProfile.setPassword("newpassword");
        assertEquals(userProfile.toString(), actual.toString());
    }

    @Test
    public void deleteTrack() throws UserProfileAlreadyExistException, UserProfileNotFoundException {
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        UserProfile actual = userDBProfileService.saveUserProfile(userProfile);
//        when(trackRepository.deleteById(track.getId())).thenReturn("Deleted");
////        trackRepository.deleteById(track.getId());
//        assertTrue(trackDBService.deleteTrack(track.getId()));
    }

    @Test
    public void getInterests() throws UserProfileAlreadyExistException, UserProfileNotFoundException{
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        List<String> actual = userDBProfileService.getInterests("ujj");
        assertArrayEquals(actual.toArray(), interests.toArray());
    }

    @Test
    public void editInterests() throws UserProfileAlreadyExistException, UserProfileNotFoundException{
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        interests.add("i4");
        List<String> actual = userDBProfileService.editInterests("ujj",interests);
        List<String> expected = new ArrayList<>();
        expected.add("i1");
        expected.add("i2");
        expected.add("i3");
        expected.add("i4");
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void updateQuestionAttempted() throws UserProfileAlreadyExistException, UserProfileNotFoundException{
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        Question question = new Question(3, "q3");
        UserProfile actual = userDBProfileService.updateQuestionAttempted("ujj",question);
        assertEquals(userProfile.toString(), actual.toString());
        assertArrayEquals(userProfile.getAttemptedQuestion().toArray(), actual.getAttemptedQuestion().toArray());
    }

    @Test
    public void updateQuestionPosted() throws UserProfileAlreadyExistException, UserProfileNotFoundException{
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        userDBProfileService.saveUserProfile(userProfile);
        Optional<UserProfile> optional = Optional.of(userProfile);
        when(userProfileRepository.findById("ujj")).thenReturn(optional);
        Question question = new Question(3, "q3");
        UserProfile actual = userDBProfileService.updateQuestionPosted("ujj",question);
        assertArrayEquals(userProfile.getAttemptedQuestion().toArray(), actual.getAttemptedQuestion().toArray());
    }


}