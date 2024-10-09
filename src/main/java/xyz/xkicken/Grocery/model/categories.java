package xyz.xkicken.Grocery.model;

import org.springframework.data.annotation.Id;

public record categories(
        @Id
        Integer category_id,
        String category_name
) {
}
