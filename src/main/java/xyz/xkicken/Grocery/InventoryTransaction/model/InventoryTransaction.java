package xyz.xkicken.Grocery.InventoryTransaction.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record InventoryTransaction(
        @Id
        Integer inventoryTransactionId,
        Integer productId,
        Integer quantityDifference,
        Integer transactionTypeId,
        LocalDateTime transactionTime

) {
}
