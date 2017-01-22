package app.repositories;

import org.springframework.data.repository.CrudRepository;
import app.domain.Product;
 
public interface ProductRepository extends CrudRepository<Product, Integer>{
}
