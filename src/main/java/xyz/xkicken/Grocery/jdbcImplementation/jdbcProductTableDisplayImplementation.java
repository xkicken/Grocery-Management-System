package xyz.xkicken.Grocery.jdbcImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class jdbcProductTableDisplayImplementation {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductTableDisplayImplementation.class);
    private final JdbcClient jdbcClient;

    public jdbcProductTableDisplayImplementation(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

}
