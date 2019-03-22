package com.stackroute.controller;

import com.stackroute.domain.Question;
import com.stackroute.domain.UserProfile;
import com.stackroute.exception.UserProfileNotFoundException;
import com.stackroute.exception.UserProfileAlreadyExistException;
import com.stackroute.service.UserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Use an interface that can be implemented by UserProfileService and UserAWSService
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
@Api(value = "UserProfile")
public class UserController {
    private UserProfileService userProfileService;

    @Autowired
    public UserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }
    
    // method to save user profile
    @ApiOperation(value = "Save a userProfile")
    @PostMapping(value = "userprofile")
    public ResponseEntity<UserProfile> updateUserProfile( @ApiParam(value = "UserProfile will be saved in database" +
            " table", required = true)@RequestBody UserProfile userProfile) throws UserProfileAlreadyExistException {
            return new ResponseEntity<>(userProfileService.saveUserProfile(userProfile), HttpStatus.OK);
    }
    
    // method to get user profile
    @GetMapping(value = "userprofile/{username}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable("username") String userName) throws UserProfileNotFoundException {
        return new ResponseEntity<>(userProfileService.getUser(userName), HttpStatus.OK);
    }
    
    // method to get list of ineterest
    @ApiOperation(value = "List of interest")
    @GetMapping(value = "interests/{username}")
    public ResponseEntity<List<String>> getInterests(@PathVariable("username") String userName) {
            return new ResponseEntity<>(userProfileService.getInterests(userName), HttpStatus.OK);
    }
    
    // method to edit list of ineterest
    @ApiOperation(value = "List of interest")
    @PostMapping(value = "interests/{username}")
    public ResponseEntity<List<String>> editInterests(@PathVariable("username") String userName, @RequestBody List<String> newInterests) {
        return new ResponseEntity<>(userProfileService.editInterests(userName, newInterests), HttpStatus.OK);
    }

    // method to delete user profile from database
    @ApiOperation(value = "Delete a user")
    @DeleteMapping(value = "{username}")
    public ResponseEntity<Boolean> deleteUserProfile( @ApiParam(value = "UserProfile with Id will be deleted from database " +
            "table", required = true)@PathVariable("username") String userName) throws UserProfileNotFoundException {
            return new ResponseEntity<>(userProfileService.deleteUser(userName), HttpStatus.OK);
    }
    
    // method to change password
    @PostMapping(value = "password/{username}")
    public ResponseEntity<UserProfile> changePassword(@PathVariable("username") String userName, @RequestBody String newPassword) throws UserProfileNotFoundException {
        return new ResponseEntity<>(userProfileService.changePassword(userName, newPassword), HttpStatus.OK);
    }

    // method update list of attempted questions 
    @PostMapping(value = "questionattempted/{username}")
    public ResponseEntity<UserProfile> updateQuestionAttempted(@PathVariable("username") String userName, @RequestBody Question question) {
        return new ResponseEntity<>(userProfileService.updateQuestionAttempted(userName, question), HttpStatus.OK);
    }
    
    // method update list of posted questions
    @PostMapping(value = "questionposted/{username}")
    public ResponseEntity<UserProfile> updateQuestionPosted(@PathVariable("username") String userName, @RequestBody Question question) {
        return new ResponseEntity<>(userProfileService.updateQuestionPosted(userName, question), HttpStatus.OK);
    }
    
    // method to test controller is working or not
    @GetMapping(value = "hi")
    public ResponseEntity<String> hi() {
        return new ResponseEntity<>("UserProfile Controller is runnig", HttpStatus.OK);
    }
}
