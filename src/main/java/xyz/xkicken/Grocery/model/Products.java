package xyz.xkicken.Grocery.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Products(
        @Id
        Integer productId,
        @NotEmpty
        String productName,
        Integer categoryId,
        Double price,
        Integer minStockQuantity,
        Double costPrice,
        Double reorderLevel,
        String unitOfMeasure,
        String shelfLocation,
        String pluCode,
        String barcode,
        Boolean isActive,
        String dateAdded,
        @Version
        Integer version
) {
}
