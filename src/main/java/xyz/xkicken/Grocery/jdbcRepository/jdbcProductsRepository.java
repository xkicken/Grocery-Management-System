package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import xyz.xkicken.Grocery.model.Products;

import java.util.List;
import java.util.Optional;

@Component
public class jdbcProductsRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductsRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcProductsRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Products> findAll() {
        return jdbcClient.sql("SELECT * FROM products")
                .query(Products.class)
                .list();
    }

    public Optional<Products> findById(int id) {
        return jdbcClient.sql("SELECT * FROM products WHERE product_id = ?")
                .param(id)
                .query(Products.class)
                .optional();
    }

    public List<Products> findBycategoryId(int id) {
        return jdbcClient.sql("SELECT * FROM products WHERE category_id = ?")
                .param(id)
                .query(Products.class)
                .list();
    }

}
