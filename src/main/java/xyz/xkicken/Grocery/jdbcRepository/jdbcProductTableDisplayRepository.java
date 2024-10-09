package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

import java.util.List;

@Repository
public class jdbcProductTableDisplayRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductTableDisplayRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcProductTableDisplayRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<ProductsTableDisplay> findAll() {
        return jdbcClient.sql("select * from products_table_display")
                .query(ProductsTableDisplay.class)
                .list();
    }

}
