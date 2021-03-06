package eu.ensup.goodstudentplan.services;

import eu.ensup.goodstudentplan.domain.Product;
import eu.ensup.goodstudentplan.dto.ProductDto;
import eu.ensup.goodstudentplan.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IProductRepository productRepository;

    @Override
    public ResponseEntity<Set<ProductDto>> findAll() {
        Iterable<Product> productIterable = productRepository.findAll();
        Set<ProductDto> productDtoSet = new HashSet<>();

        for (Product product: productIterable) {
            productDtoSet.add(convertToDto(product));
        }
        return new ResponseEntity<>(productDtoSet,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDto> findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(user -> new ResponseEntity<>(convertToDto(user),HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return new ResponseEntity<>(convertToDto(productRepository.save(convertToEntity(productDto))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProduct(int id) {
        return null;
    }

    @Override
    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public Product convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto,Product.class);
    }
}
