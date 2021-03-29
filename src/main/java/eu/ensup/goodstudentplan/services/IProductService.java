package eu.ensup.goodstudentplan.services;

import eu.ensup.goodstudentplan.domain.Product;
import eu.ensup.goodstudentplan.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IProductService {

    ResponseEntity<Set<ProductDto>> findAll();

    ResponseEntity<ProductDto> findById(long id);

    ResponseEntity<ProductDto> createProduct(ProductDto productDto);

    ResponseEntity<HttpStatus> deleteProduct(long id);

    ProductDto convertToDto(Product product);

    Product convertToEntity(ProductDto productDto);
}
