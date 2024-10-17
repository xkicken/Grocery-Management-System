package xyz.xkicken.Grocery.InventoryTranscation.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.util.Date;

public record InventoryTranscation(
    @Id
    Integer inventoryTranscationId,
    Integer productId,
    Integer quantityDifference,
    Integer priorQuantity,
    Integer current_quantity,
    String transcationDate
    
) {
}
