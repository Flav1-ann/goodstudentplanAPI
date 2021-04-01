package eu.ensup.goodstudentplan.controller;

import eu.ensup.goodstudentplan.dto.ProductDto;
import eu.ensup.goodstudentplan.dto.UserDto;
import eu.ensup.goodstudentplan.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/findAll")
    public ResponseEntity<Set<ProductDto>> findAllProduct(){ return productService.findAll(); }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDto> findBy(@PathVariable int id){ return productService.findById(id); }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createUser(@Validated @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
}
