package com.stackroute.security.services;

import com.stackroute.model.User;
import com.stackroute.repository.RoleRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @Autowired
    UserRepository userRepository;

   @Autowired
   RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @KafkaListener(topics = "AuthMessage", groupId = "group_id_auth")
    public void consume(String message){
        String[] strMessage = message.split(",");
        User user = new User();
        user.setName(strMessage[6].split(":")[1].replace("\"","") +
                " " + strMessage[7].split(":")[1].replace("\"",""));
        user.setEmail(strMessage[11].split(":")[1].replace("\"",""));
        user.setUsername(strMessage[0].split(":")[1].replace("\"",""));
        user.setPassword(strMessage[1].split(":")[1].replace("\"",""));
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        userRepository.save(user);
        System.out.println("Consumed msg : " + message);
    }
}