package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.products;

import java.util.List;

public interface productsRepository extends ListCrudRepository<products, Integer> {

    List<products> findBycategoryId(int id);
}
