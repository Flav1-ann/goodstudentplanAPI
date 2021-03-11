package eu.ensup.goodstudentplan.repository;

import eu.ensup.goodstudentplan.domain.Product;
import eu.ensup.goodstudentplan.repository.projection.ProductProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IProductRepository extends CrudRepository<Product,Long> {



    @Query(value = "select * from product",nativeQuery = true)
    Set<ProductProjection> findAllMinimal();
}

