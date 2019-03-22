package com.stackroute.config;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
@Configuration
@PropertySource("classpath:seed.properties")
@Component
public class DatabaseLoader implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${gender2}")
    private String gender1;
    @Value("${username2}")
    private String username1;
    @Value("${password2}")
    private String password1;
    @Value("${age2}")
    private int age1;
    @Value("${currentCompany2}")
    private String currentCompany1;
    @Value("${course2}")
    private String course1;
    @Value("${firstName2}")
    private String firstName1;
    @Value("${lastName2}")
    private String lastName1;
    @Value("${discipline2}")
    private String discipline1;
    @Value("${emailId2}")
    private String emailId1;
    @Value("${collegeName2}")
    private String collegeName1;

    @Autowired
    private UserRepository userRepository;

    //Method to be over-ridden for applicationListener
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        seedData();
    }

    private void seedData() {
        User user2 = new User();
        user2.setAge(age1);
        user2.setPassword(password1);
        user2.setCourse(course1);
        user2.setDiscipline(discipline1);
        user2.setCompany(currentCompany1);
        user2.setEmailId(emailId1);
        user2.setFirstName(firstName1);
        user2.setLastName(lastName1);
        user2.setGender(gender1);
        user2.setUsername(username1);
        user2.setCollege(collegeName1);
        userRepository.save(user2);

    }

}


