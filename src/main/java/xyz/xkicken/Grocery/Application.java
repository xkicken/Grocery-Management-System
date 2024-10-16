package xyz.xkicken.Grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;


@SpringBootApplication
@EnableJdbcRepositories("xyz.xkicken.Grocery.Products.repository")
@EntityScan("xyz.xkicken.Grocery.Products.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
