package xyz.xkicken.Grocery.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

import java.util.List;

public interface ProductsTableDisplayPagingRepository extends PagingAndSortingRepository<ProductsTableDisplay, Integer> {
    Page<ProductsTableDisplay> findByCategoryId(Integer id, Pageable pageable);
}
