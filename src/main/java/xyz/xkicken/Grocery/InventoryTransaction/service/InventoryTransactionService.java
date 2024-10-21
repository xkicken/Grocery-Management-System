package xyz.xkicken.Grocery.InventoryTransaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.InventoryTransaction.model.InventoryTableDisplay;
import xyz.xkicken.Grocery.InventoryTransaction.repository.InventoryTransactionRepository;
import xyz.xkicken.Grocery.InventoryTransaction.repository.InventoryTableViewPagingRepository;

@Service
public class InventoryTransactionService {
    private static final Logger log = LoggerFactory.getLogger(InventoryTransactionService.class);
    private final InventoryTransactionRepository inventoryTransactionRepository;
    private final InventoryTableViewPagingRepository inventoryTableViewPagingRepository;

    public InventoryTransactionService(InventoryTransactionRepository inventoryTransactionRepository, InventoryTableViewPagingRepository inventoryTableViewPagingRepository) {
        this.inventoryTransactionRepository = inventoryTransactionRepository;
        this.inventoryTableViewPagingRepository = inventoryTableViewPagingRepository;
    }

    public Page<InventoryTableDisplay> getInventoryTableView(Integer page, Integer size, String sortBy, String direction) {
        log.info("Fetching inventory table view for page: {}, size: {}, sortBy: {}, direction: {}", page, size, sortBy, direction);
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return inventoryTableViewPagingRepository.findAll(pageable);
    }

    public Page<InventoryTableDisplay> getInventoryTableViewBySearch(Integer page, Integer size, String search) {
        log.info("Fetching inventory table view for page: {}, size: {}, search: {}", page, size, search);
        Pageable pageable = PageRequest.of(page, size);
        return inventoryTableViewPagingRepository.findByProductNameContainingIgnoreCase(search, pageable);
    }
}
