package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private UserService userService;
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//Request mapping for posting user details
    @PostMapping("register")
    public ResponseEntity saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
            kafkaTemplate.send("AuthMessage",user);
        }
        catch (UserAlreadyExistsException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
//Request mapping for getting user details
    @GetMapping("users")
    public ResponseEntity<List<User>> listOfUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
//Request mapping for deleting user details
    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String userId){
        ResponseEntity responseEntity;
        try {
            User user = userService.deleteUser(userId);
            responseEntity = new ResponseEntity<User>(user, HttpStatus.GONE);
        }
        catch (UserNotFoundException userNotFoundException){
            responseEntity = new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }
    //Request mapping for updating user details
    @PutMapping("users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        ResponseEntity responseEntity;
        try{
            User user1 = userService.updateUser(userId,user);
            responseEntity = new ResponseEntity<User>(user1, HttpStatus.OK);
        }
        catch (UserNotFoundException ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/publish/{email}")
    public String post(@PathVariable("email") String email){
        User user = userService.getUserByEmailid(email);
        kafkaTemplate.send("AuthMessage",user);
        return "Published Successfully";
    }

}

