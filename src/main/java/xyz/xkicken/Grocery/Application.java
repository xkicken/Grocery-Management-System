package xyz.xkicken.Grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableJdbcRepositories(basePackages = {
		"xyz.xkicken.Grocery.Products.repository",
		"xyz.xkicken.Grocery.InventoryTransaction.repository"
})
@EntityScan(basePackages = {
		"xyz.xkicken.Grocery.Products.model",
		"xyz.xkicken.Grocery.InventoryTransaction.model"
})
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
