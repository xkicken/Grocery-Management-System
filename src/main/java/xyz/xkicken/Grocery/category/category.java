package xyz.xkicken.Grocery.category;

import org.springframework.data.annotation.Id;

public record category(
        @Id
        Integer category_id,
        String category_name
) {
}
