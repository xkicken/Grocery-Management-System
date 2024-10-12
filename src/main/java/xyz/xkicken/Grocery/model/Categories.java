package xyz.xkicken.Grocery.model;

import org.springframework.data.annotation.Id;

public record Categories(
        @Id
        Integer category_id,
        String category_name
) {
}
