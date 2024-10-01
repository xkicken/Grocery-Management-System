package xyz.xkicken.Grocery.products;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record products(
        @Id
        Integer productId,
        @NotEmpty
        String productName,
        Integer categoryId,
        Double price,
        Integer stockQuantity,
        Integer minStockQuantity,
        Double costPrice,
        Double reorderLevel,
        String unitOfMeasure,
        String shelfLocation,
        String pluCode,
        String barcode,
        String expirationDate,
        Boolean isActive,
        String dateAdded,
        @Version
        Integer version
) {
}
