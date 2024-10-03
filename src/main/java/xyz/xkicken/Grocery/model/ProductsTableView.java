package xyz.xkicken.Grocery.model;

public record ProductsTableView(
        String productName,
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
