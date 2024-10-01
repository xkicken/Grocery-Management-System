package xyz.xkicken.Grocery.products;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface productsRepository extends ListCrudRepository<products, Integer> {

    List<products> findBycategoryId(int id);
}
