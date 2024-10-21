package xyz.xkicken.Grocery.InventoryTransaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.xkicken.Grocery.InventoryTransaction.model.InventoryTableDisplay;

public interface InventoryTableViewPagingRepository extends PagingAndSortingRepository<InventoryTableDisplay, Integer> {
    Page<InventoryTableDisplay> findByProductNameContainingIgnoreCase(String productName, Pageable pageable);


}
