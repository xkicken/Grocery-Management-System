package xyz.xkicken.Grocery.products;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record products(
        @Id
        Integer product_id,
        @NotEmpty
        String product_name,
        Integer category_id,
        Double price,
        Integer stock_quantity,
        Integer min_stock_quantity,
        Double cost_price,
        Double reorder_level,
        String unit_of_measure,
        String shelf_location,
        String plu_code,
        String barcode,
        String expiration_date,
        Boolean is_active,
        String date_added,
        @Version
        Integer version
) {
}
