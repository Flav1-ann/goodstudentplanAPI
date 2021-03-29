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
    void findAllProduct(){
        assertEquals(((ArrayList)productRepository.findAll()).size(), 2);
    }
    @Test
    void findOneProduct(){
        assertEquals(productRepository.findById((long)1).get().getPrice(), 12);
    }
}
