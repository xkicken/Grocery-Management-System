package xyz.xkicken.Grocery.model;

import org.springframework.data.annotation.Id;


public record ProductsTableDisplay(
        @Id
        Integer productId,
        String productName,
        Integer categoryId,
        String categoryName,
        double price,
        double costPrice,
        Integer stockQuantity,
        String unitOfMeasure,
        Integer minStockQuantity,
        Integer reorderLevel,
        String shelfLocation,
        String pluCode,
        String barcode,
        String expirationDate
) {
}
