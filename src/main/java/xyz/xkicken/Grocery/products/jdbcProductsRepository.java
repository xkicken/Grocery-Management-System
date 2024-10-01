package xyz.xkicken.Grocery.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;
import java.util.Optional;

public class jdbcProductsRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductsRepository.class);
    private  final JdbcClient jdbcClient;

    public jdbcProductsRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<products> findAll() {
        return jdbcClient.sql("select * from products")
                .query(products.class)
                .list();
    }

    public Optional<products> findById(int id) {
        return jdbcClient.sql("select * from products where product_id = ?")
                .param(id)
                .query(products.class)
                .optional();
    }

}
