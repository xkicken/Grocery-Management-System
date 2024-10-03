package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.model.ProductsTableView;

import java.util.List;

public interface ProductsTableViewRepository extends ListCrudRepository<ProductsTableView, Integer> {
    List<ProductsTableView> findAll();
}
