package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

import java.util.List;

public interface ProductsTableDisplayRepository extends ListCrudRepository<ProductsTableDisplay, Integer> {
}
