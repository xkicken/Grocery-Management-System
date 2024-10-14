package xyz.xkicken.Grocery.jdbcImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class jdbcCategoryImplementation {

    private static final Logger log = LoggerFactory.getLogger(jdbcCategoryImplementation.class);
    private final JdbcClient jdbcClient;

    public jdbcCategoryImplementation(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

}