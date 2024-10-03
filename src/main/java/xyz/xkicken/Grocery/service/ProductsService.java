package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import xyz.xkicken.Grocery.jdbcRepository.jdbcProductsRepository;
import xyz.xkicken.Grocery.model.products;
import xyz.xkicken.Grocery.repository.productsRepository;


@Service
public class ProductsService implements productsRepository {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final jdbcProductsRepository JdbcProductsRepository;  // Inject the repository

    public ProductsService(jdbcProductsRepository JdbcProductsRepository) {
        this.JdbcProductsRepository = JdbcProductsRepository;
    }

    @Override
    public List<products> getAllProducts() {
        log.info("Fetching all products");
        return JdbcProductsRepository.findAll();
    }

    @Override
    public Optional<products> getProductById(int id) {
        log.info("Fetching product with ID: {}", id);
        return JdbcProductsRepository.findById(id);
    }

    @Override
    public List<products> getProductsByCategoryId(int categoryId) {
        log.info("Fetching products for category ID: {}", categoryId);
        return JdbcProductsRepository.findBycategoryId(categoryId);
    }
}
