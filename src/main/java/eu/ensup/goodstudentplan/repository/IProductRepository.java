package eu.ensup.goodstudentplan.repository;

import eu.ensup.goodstudentplan.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product,Integer> {
}
