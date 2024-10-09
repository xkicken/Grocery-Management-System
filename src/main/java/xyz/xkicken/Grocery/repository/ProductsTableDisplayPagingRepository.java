package xyz.xkicken.Grocery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

public interface ProductsTableDisplayPagingRepository extends PagingAndSortingRepository<ProductsTableDisplay, Integer> {
}
