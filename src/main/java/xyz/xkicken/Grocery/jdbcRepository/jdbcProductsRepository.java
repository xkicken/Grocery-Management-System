package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import xyz.xkicken.Grocery.model.Products;
import xyz.xkicken.Grocery.repository.CustomProductsRepository;

import java.util.List;
import java.util.Optional;

@Component
public class jdbcProductsRepository implements CustomProductsRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductsRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcProductsRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public void updateProducts(Products products, int id) {
        var updated = jdbcClient.sql("UPDATE products SET product_name = ?, category_id = ?, price = ?, cost_price = ?, unit_of_measure = ?, shelf_location = ?, plu_code = ?, barcode = ? WHERE product_id = ?")
                .param(products.productName())
                .param(products.categoryId())
                .param(products.price())
                .param(products.costPrice())
                .param(products.unitOfMeasure())
                .param(products.shelfLocation())
                .param(products.pluCode())
                .param(products.barcode())
                .param(id)
                .update();
    }

}
