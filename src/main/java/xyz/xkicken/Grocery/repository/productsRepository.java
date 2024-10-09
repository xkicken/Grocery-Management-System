package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.products;

import java.util.List;
import java.util.Optional;

public interface productsRepository extends ListCrudRepository<products, Integer> {
    List<products> getProductsByCategoryId(int categoryId);
    List<products> findAll();
    Optional<products> findById(Integer integer);
}
