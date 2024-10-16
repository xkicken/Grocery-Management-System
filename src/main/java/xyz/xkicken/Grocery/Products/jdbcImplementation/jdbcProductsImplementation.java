package xyz.xkicken.Grocery.Products.jdbcImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import xyz.xkicken.Grocery.Products.model.Products;
import xyz.xkicken.Grocery.Products.repository.CustomProductsRepository;

@Component
public class jdbcProductsImplementation implements CustomProductsRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductsImplementation.class);
    private final JdbcClient jdbcClient;

    public jdbcProductsImplementation(JdbcClient jdbcClient) {
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

    public void deleteProducts(int id) {
        var deleted = jdbcClient.sql("DELETE FROM products WHERE product_id = ?")
                .param(id)
                .update();
    }

}
