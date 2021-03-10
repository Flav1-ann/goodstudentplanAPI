package eu.ensup.goodstudentplan.controller;

import eu.ensup.goodstudentplan.dto.ProductDto;
import eu.ensup.goodstudentplan.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProductDto> findBy(@PathVariable long id){ return productService.findById(id); }
}
