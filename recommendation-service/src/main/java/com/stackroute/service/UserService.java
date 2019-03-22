package com.stackroute.service;

import com.stackroute.model.Question;
import com.stackroute.model.User;
import com.stackroute.repository.QuestionTagRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionTagRepository tagRepository;


//    public void  Question saveQuestion(Question question){
//           userRepository.saveQuestion(question.getQuestionId(),question.getQuestionTitle(),
//                   question.getQuestionDescription(),question.getDifficulty(),question.getTags());
//    }

    public User createUserNode(User user){
        return userRepository.save(user);
    }
    public User deleteUser(User user){
        System.out.println(user.getUsername());
              tagRepository.deleteAllByUsername(user.getUsername());
        //tagRepository.
          userRepository.delete(user.getUsername());

        return null;                  }

    public List<Question> getAllQuestions(){

        Random rand = new Random();
        int arr[]=new int [10];

        for(int i=0;i<10;i++)
        {
           int rand_int1 =1+rand.nextInt(50);
           int  j=0;
           while(j<=i)
           {
               if(arr[i]==rand_int1)
               {
                   rand_int1=1+rand.nextInt(50);
                   j=0;
               }
               j++;
           }
           arr[i]=rand_int1;
        }
        for(int i=0;i<10;i++)
            System.out.print(arr[i]+" ");

         List<Question> qlist=new ArrayList<Question>();
         for(int i=0;i<10;i++)
         {
             Question q1=userRepository.findquestionbyId(String.valueOf(arr[i]));
             qlist.add(q1);
         }
         return qlist;

    }

}
