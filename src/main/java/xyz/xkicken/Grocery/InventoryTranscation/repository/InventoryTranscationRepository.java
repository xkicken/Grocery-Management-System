package xyz.xkicken.Grocery.InventoryTranscation.repository;

import org.springframework.data.repository.ListCrudRepository;
import xyz.xkicken.Grocery.InventoryTranscation.model.InventoryTranscation;

public interface InventoryTranscationRepository extends ListCrudRepository<InventoryTranscation, Integer> {
}
