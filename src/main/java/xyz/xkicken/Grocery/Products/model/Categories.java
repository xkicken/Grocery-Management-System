package xyz.xkicken.Grocery.Products.model;

import org.springframework.data.annotation.Id;

public record Categories(
        @Id
        Integer category_id,
        String category_name
) {
}
