package eu.ensup.goodstudentplan;


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
    void findAllUser() throws Exception{
        assertEquals(((ArrayList)UserRepository.findAll()).size(), 1);
    }

}
