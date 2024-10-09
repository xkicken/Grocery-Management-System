package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import xyz.xkicken.Grocery.model.category;

import java.util.List;

@Component
public class jdbcCategoryRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcCategoryRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcCategoryRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<category> findAll() {
        return jdbcClient.sql("SELECT * FROM categories")
                .query(category.class)
                .list();
    }

    public void create(category category) {
        var updated = jdbcClient.sql("INSERT INTO category(category_name) values(?)")
                .params(category.category_name())
                .update();

        Assert.state(updated == 1, "Failed to create category " + category.category_name());
    }


    public void saveAll(List<category> runs) {
        runs.stream().forEach(this::create);
    }
}
