package xyz.xkicken.Grocery.InventoryTransaction.model;

import java.time.LocalDateTime;

public record InventoryTableDisplay(
        Integer inventoryTransactionId,
        Integer productId,
        String productName,
        Integer quantityDifference,
        Integer transactionTypeId,
        String transactionTypeName,
        LocalDateTime transactionTime
) {
}
