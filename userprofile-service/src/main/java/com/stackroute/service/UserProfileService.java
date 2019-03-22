package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.UserProfile;
import com.stackroute.exception.UserProfileAlreadyExistException;
import com.stackroute.exception.UserProfileNotFoundException;
import java.util.List;

// interface for UserProfileService
public interface UserProfileService {
    public UserProfile saveUserProfile(UserProfile userProfile) throws UserProfileAlreadyExistException;
    public Boolean deleteUser(String userName) throws UserProfileNotFoundException;
    public UserProfile changePassword(String userName, String newPassword) throws UserProfileNotFoundException;
    public List<String> editInterests(String userName, List<String> newInterests);
    public List<String> getInterests(String userName);
    public UserProfile getUser(String userName) throws UserProfileNotFoundException;
    public UserProfile updateQuestionAttempted(String userName, Question questionAttempted);
    public UserProfile updateQuestionPosted(String userName, Question questionPosted);
}
