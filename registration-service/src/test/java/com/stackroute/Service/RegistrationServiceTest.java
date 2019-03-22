//package com.stackroute.Service;
//
//
//import com.stackroute.domain.User;
//import com.stackroute.exception.UserAlreadyExistsException;
//import com.stackroute.exception.UserNotFoundException;
//import com.stackroute.repository.UserRepository;
//import com.stackroute.service.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//public class RegistrationServiceTest {
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    UserServiceImpl serviceImpl;
//
//    private User user;
//    List<User> userList;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        user=new User();
//        user.setUsername("mahe12");
//        user.setPassword("blowin in the wind");
//        user.setGender("Nice song");
//        user.setLastName("mahe12");
//        user.setFirstName("blowin in the wind");
//        user.setEmailId("Nice song");
//        user.setCourse("mahe12");
//        user.setDiscipline("blowin in the wind");
//        user.setCollege("Nice song");
//        user.setAge(25);
//        user.setInterest("blowin in the wind");
//        user.setCompany("Nice song");
//    }
//
//    @Test
//    public void testSaveByName() throws UserAlreadyExistsException {
//
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//        User  expectedList=serviceImpl.saveUser(user);
//        assertEquals(user,expectedList);
//    }
//
//    @Test
//    public void getAllTrackTest()
//    {
//        List<User> list = new ArrayList<User>();
//        User empOne = new User();
//        empOne.setUsername("mahe12");
//        empOne.setPassword("blowin in the wind");
//        empOne.setGender("Nice song");
//        empOne.setLastName("mahe12");
//        empOne.setFirstName("blowin in the wind");
//        empOne.setEmailId("Nice song");
//        empOne.setCourse("mahe12");
//        empOne.setDiscipline("blowin in the wind");
//        empOne.setCollege("Nice song");
//        empOne.setAge(25);
//        empOne.setInterest("blowin in the wind");
//        empOne.setCompany("Nice song");
//        User empTwo = new User();
//        empTwo.setUsername("mahe123");
//        empTwo.setPassword("blowin in the wind12");
//        empTwo.setGender("Nice song");
//        empTwo.setLastName("mahe12");
//        empTwo.setFirstName("blowin in the wind");
//        empTwo.setEmailId("Nice song1");
//        empTwo.setCourse("mahe12");
//        empTwo.setDiscipline("blowin in the wind");
//        empTwo.setCollege("Nice song");
//        empTwo.setAge(26);
//        empTwo.setInterest("blowin in the wind1");
//        empTwo.setCompany("Nice song");
//        User empThree = new User();
//        user.setUsername("mahe1234");
//        user.setPassword("blowin in the wind3");
//        user.setGender("Nice song3");
//        user.setLastName("mahe12");
//        user.setFirstName("blowin in the wind");
//        user.setEmailId("Nice song8");
//        user.setCourse("mahe12");
//        user.setDiscipline("blowin in the wind");
//        user.setCollege("Nice song");
//        user.setAge(25);
//        user.setInterest("blowin in the wind9");
//        user.setCompany("Nice song");
//
//        list.add(empOne);
//        list.add(empTwo);
//        list.add(empThree);
//
//        when(userRepository.findAll()).thenReturn(list);
//
//        //test
//        List<User> userList = serviceImpl.getAllUsers();
//
//        // assertEquals(3, trackList.size());
//        assertEquals(list,userList);
//    }
//
//
////    @Test
////    public void testRemoveTrack() {
////        //Muzix muzix = new Muzix(1, "hey jude","yeah");
////
////        List<User> userli = Arrays.asList(
////                new User(1, "dont let me down","nice"));
////        when(userRepository.deleteById(8);).thenReturn(userli);
////
//////        doNothing().when(muzixRepository.findById(anyInt()));
//////        doNothing().when(muzixRepository.deleteById(anyInt()));
////
////        verify(userRepository, times(0)).deleteById(user.getEmailId());
////
////    }
//
//}
