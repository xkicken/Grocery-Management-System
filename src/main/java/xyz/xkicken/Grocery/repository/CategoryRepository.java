package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.category;

public interface CategoryRepository extends ListCrudRepository<category, Integer> {

}
