package xyz.xkicken.Grocery.Products.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;

public interface ProductsTableDisplayPagingRepository extends PagingAndSortingRepository<ProductsTableDisplay, Integer> {
    Page<ProductsTableDisplay> findByCategoryId(Integer id, Pageable pageable);
}
