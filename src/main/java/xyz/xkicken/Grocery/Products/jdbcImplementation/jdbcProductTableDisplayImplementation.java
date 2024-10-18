package xyz.xkicken.Grocery.Products.jdbcImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.Products.repository.CustomProductTableDisplayRepository;

import java.util.List;

@Component
public class jdbcProductTableDisplayImplementation implements CustomProductTableDisplayRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductTableDisplayImplementation.class);
    private final JdbcClient jdbcClient;

    public jdbcProductTableDisplayImplementation(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public List<ProductsTableDisplay> searchProductsByColumn(String column, String query) {
        // Constructing the SQL query
        String sql = "SELECT * FROM products WHERE " + column + " LIKE ?";
        return jdbcClient.sql(sql)
                .param(query)
                .query(ProductsTableDisplay.class)
                .list();
    }

}
