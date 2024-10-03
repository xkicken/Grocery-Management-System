package xyz.xkicken.Grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.jdbcRepository.jdbcProductsRepository;
import xyz.xkicken.Grocery.repository.productsRepository;
import xyz.xkicken.Grocery.model.products;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final xyz.xkicken.Grocery.repository.productsRepository productsRepository; // JPA Repository
    private final xyz.xkicken.Grocery.jdbcRepository.jdbcProductsRepository jdbcProductsRepository; // JDBC Repository

    @Autowired
    public ProductsService(productsRepository productsRepository, jdbcProductsRepository jdbcProductsRepository) {
        this.productsRepository = productsRepository;
        this.jdbcProductsRepository = jdbcProductsRepository;
    }

    // Use JPA repository for CRUD operations
    public List<products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<products> getProductById(int id) {
        return productsRepository.findById(id);
    }

    public List<products> getProductsByCategoryId(int categoryId) {
        return productsRepository.findBycategoryId(categoryId);
    }

    // Use JDBC repository for custom queries
    public List<products> getAllProductsUsingJdbc() {
        return jdbcProductsRepository.findAll();
    }

    public Optional<products> getProductByIdUsingJdbc(int id) {
        return jdbcProductsRepository.findById(id);
    }
}
