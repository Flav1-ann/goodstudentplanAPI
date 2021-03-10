package eu.ensup.goodstudentplan;

import eu.ensup.goodstudentplan.repository.IProductRepository;
import eu.ensup.goodstudentplan.repository.IUserRepository;
import eu.ensup.goodstudentplan.services.ProductServiceImpl;
import eu.ensup.goodstudentplan.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GoodstudentplanApplicationTests {

    @Autowired
    IProductRepository productRepository;

    @Test
    void findAllProduct() throws Exception{
        assertEquals(((ArrayList)productRepository.findAll()).size(), 2);
    }

}
