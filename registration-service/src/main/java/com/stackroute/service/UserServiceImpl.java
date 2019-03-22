package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) throws UserAlreadyExistsException {
        if (userRepository.existsByEmailId(user.getEmailId())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        //Encrypting password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUser(String userId) throws UserNotFoundException {
        User user1 = userRepository.findByEmailId(userId);
        if (userRepository.existsById(userId))
            userRepository.deleteById(userId);
        else {
            throw new UserNotFoundException("User not found");
        }
        return user1;

    }

    public User updateUser(String userId, User user) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            return userRepository.save(user);
        } else
            throw new UserNotFoundException("User not found");

    }

    @Override
    public User getUserByEmailid(String emailId) {
        return userRepository.findByEmailId(emailId);
    }
}

