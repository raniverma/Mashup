//package com.stackroute.Repository;
//
//import com.stackroute.domain.User;
//import com.stackroute.repository.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class RegistrationRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private User user;
//
//    @Before
//    public void setUp() throws Exception {
//
//        user = new User();
//    }
//
//    @Test
//    public void testRegisterUserSuccess() {
//
//        userRepository.save(user);
//        Optional<User> object = userRepository.findById(user.getEmailId());
//        assertThat(object.equals(user));
//    }
//
////    @Test
////    public void testFindByNameSuccess() {
////        userRepository.findByName("john");
////        Optional<Muzix> object=muzixRepository.findById(muzix.getId());
////        assertThat(object.equals(muzix));
////    }
//
//
//
//}
