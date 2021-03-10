package eu.ensup.goodstudentplan;

import eu.ensup.goodstudentplan.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {
    @Autowired
    IProductRepository productRepository;

    @Test
    void findAllProduct() throws Exception{
        assertEquals(((ArrayList)productRepository.findAll()).size(), 2);
    }
}
