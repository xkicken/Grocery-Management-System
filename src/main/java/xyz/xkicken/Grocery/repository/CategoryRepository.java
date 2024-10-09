package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.categories;

import java.util.List;

public interface CategoryRepository extends  ListCrudRepository<categories, Integer> {

        List<categories> findAll();
}
