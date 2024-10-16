package xyz.xkicken.Grocery.Products.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;

import java.util.List;

public interface ProductsTableDisplayRepository extends ListCrudRepository<ProductsTableDisplay, Integer> {
    List<ProductsTableDisplay> findAll();
    List<ProductsTableDisplay> findByCategoryId(Integer id);
    Iterable<ProductsTableDisplay> findAll(Sort sort);
}
