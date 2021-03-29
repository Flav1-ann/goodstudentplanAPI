package eu.ensup.goodstudentplan;


import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    @Autowired
    IUserRepository UserRepository;

    @Test
    void findAllUser(){
        assertEquals(((ArrayList)UserRepository.findAll()).size(), 2);
    }
    @Test
    void findOneUser(){
        assertEquals(UserRepository.findById((long)3).get().getLastName(), "jean");
    }

}
