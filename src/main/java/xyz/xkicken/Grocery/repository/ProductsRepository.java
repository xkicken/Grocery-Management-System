package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends ListCrudRepository<Products, Integer> {
    List<Products> getProductsByCategoryId(int categoryId);
    List<Products> findAll();
    Optional<Products> findById(Integer integer);
}
