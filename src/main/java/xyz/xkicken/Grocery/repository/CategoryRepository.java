package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.category;

import java.util.List;

public interface CategoryRepository{

        List<category> GetAllCategory();
}
