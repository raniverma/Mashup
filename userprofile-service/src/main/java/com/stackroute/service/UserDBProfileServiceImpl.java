package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.UserProfile;
import com.stackroute.exception.UserProfileAlreadyExistException;
import com.stackroute.exception.UserProfileNotFoundException;
import com.stackroute.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// class implementing the UserProfileService inteface
@Service
public class UserDBProfileServiceImpl implements UserProfileService {


    private UserProfileRepository userProfileRepository;
    private String prefix = "UserProfile with ";
    private String sufix = " doesnot exist";
    @Autowired
    public UserDBProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    // method to save userprofile to mongo database
    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) throws UserProfileAlreadyExistException {
//        if (userProfileRepository.existsById(userProfile.getUserName())) {
//            throw new UserProfileAlreadyExistException("UserProfile already exist with id" + userProfile.getUserName());
//        }
        return userProfileRepository.save(userProfile);
    }
    
    // method to get userprofile from mongo database
    @Override
    public UserProfile getUser(String userName) throws UserProfileNotFoundException {
        if (!userProfileRepository.existsById(userName)) {
            throw new UserProfileNotFoundException(prefix + userName + sufix);
        }
        Optional<UserProfile> tempUser = userProfileRepository.findById(userName);
        if (tempUser.isPresent()) {
            return tempUser.get();
        }
        return null;
    }

    // method to delete userprofile from mongo database
    @Override
    public Boolean deleteUser(String userName) throws UserProfileNotFoundException {
        if (!userProfileRepository.existsById(userName)) {
            throw new UserProfileNotFoundException(prefix + userName + sufix);
        }
        userProfileRepository.deleteById(userName);
        return true;
    }

    // method to change password to mongo database
    @Override
    public UserProfile changePassword(String userName, String newPassword) throws UserProfileNotFoundException {
        if (!userProfileRepository.existsById(userName)) {
            throw new UserProfileNotFoundException(prefix + userName + sufix);
        }
        Optional<UserProfile> tempUser = userProfileRepository.findById(userName);
        if (tempUser.isPresent()) {
            tempUser.get().setPassword(newPassword);
            return userProfileRepository.save(tempUser.get());
        }
        return null;
    }

    // method to get list of interest from mongo database
    @Override
    public List<String> getInterests(String userName) {
        Optional<UserProfile> tempUser = userProfileRepository.findById(userName);
        if (tempUser.isPresent()) {
            return tempUser.get().getInterests();
        }
        return new ArrayList<>();
    }

    // method to edit list of interest to mongo database    
    @Override
    public List<String> editInterests(String userName, List<String> newInterests) {
        Optional<UserProfile> tempUser = userProfileRepository.findById(userName);
        if (tempUser.isPresent()) {
            tempUser.get().setInterests(newInterests);
            userProfileRepository.save(tempUser.get());
            return tempUser.get().getInterests();
        }
        return new ArrayList<>();
    }

    // method to update list of attempted questions to mongo database
    @Override
    public UserProfile updateQuestionAttempted(String userName, Question questionAttempted) {
        Optional<UserProfile> temp = userProfileRepository.findById(userName);
        System.out.println("status : " + temp.isPresent());
        List<Question> questionAttempedList;
        if (temp.isPresent()) {
            questionAttempedList = temp.get().getAttemptedQuestion();
            boolean state = false;
            for (Question quesAttempt : questionAttempedList) {
                if (quesAttempt.getQuestionId() == questionAttempted.getQuestionId()) {
                    state = true;
                }
            }
            if (state == false) {
                temp.get().getAttemptedQuestion().add(questionAttempted);
            }
            return userProfileRepository.save(temp.get());
        }
        return null;
    }
    
    // method to update list of posted questions to mongo database
    @Override
    public UserProfile updateQuestionPosted(String userName, Question questionPosted) {
        Optional<UserProfile> temp = userProfileRepository.findById(userName);
        if (temp.isPresent()) {
            temp.get().getPostedQuestion().add(questionPosted);
            return userProfileRepository.save(temp.get());
        }
        return null;
    }
}
