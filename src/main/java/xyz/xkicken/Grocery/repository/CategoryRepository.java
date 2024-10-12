package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.Categories;

import java.util.List;

public interface CategoryRepository extends  ListCrudRepository<Categories, Integer> {

        List<Categories> findAll();
}
