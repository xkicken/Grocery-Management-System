package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.products;

import java.util.List;
import java.util.Optional;

public interface productsRepository{

    List<products> getAllProducts();
    Optional<products> getProductById(int id);
    List<products> getProductsByCategoryId(int categoryId);
}
