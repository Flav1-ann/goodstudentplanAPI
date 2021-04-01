package eu.ensup.goodstudentplan.productTest;

import eu.ensup.goodstudentplan.domain.Product;
import eu.ensup.goodstudentplan.domain.User;
import eu.ensup.goodstudentplan.dto.UserDto;
import eu.ensup.goodstudentplan.repository.IProductRepository;
import eu.ensup.goodstudentplan.repository.IUserRepository;
import eu.ensup.goodstudentplan.services.UserServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    IUserRepository userRepository;
    @Test
    @Disabled
    void findAllProduct(){

        assertEquals(((ArrayList)productRepository.findAll()).size(), 18);
    }
    @Test
    void findOneProduct(){
        assertEquals(productRepository.findById(1).get().getPrice(), 12);
    }

    @Test
    void createdProduct() throws MalformedURLException {
        int sizeBefore =((ArrayList)productRepository.findAll()).size();
        Optional<User> userOptional = userRepository.findById(1);
        User user = null;
        if(userOptional.isPresent())
        {
             user = userOptional.get();
        }
        productRepository.save(new Product(0, "test", "test", "tes"
                , 1,null,null,"","", user ));
        int sizeAfter =((ArrayList)productRepository.findAll()).size();
        assertEquals(sizeBefore+1,sizeAfter);
    }

    @Test
    @Disabled
    void deleteProduct() throws MalformedURLException {
        int sizeBefore =((ArrayList)productRepository.findAll()).size();
        productRepository.deleteById(6);
        int sizeAfter =((ArrayList)productRepository.findAll()).size();
        assertEquals(sizeBefore-1,sizeAfter);
    }
}
