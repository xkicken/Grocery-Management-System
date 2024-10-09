package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import xyz.xkicken.Grocery.model.categories;

import java.util.List;

@Component
public class jdbcCategoryRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcCategoryRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcCategoryRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<categories> findAll() {
        return jdbcClient.sql("SELECT * FROM categories")
                .query(categories.class)
                .list();
    }
}