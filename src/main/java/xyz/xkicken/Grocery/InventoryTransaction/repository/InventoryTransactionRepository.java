package xyz.xkicken.Grocery.InventoryTransaction.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.InventoryTransaction.model.InventoryTransaction;

public interface InventoryTransactionRepository extends ListCrudRepository<InventoryTransaction, Integer> {
}
