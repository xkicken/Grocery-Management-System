package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.model.products;
import xyz.xkicken.Grocery.repository.productsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final productsRepository productsRepository;  // Inject the repository

    public ProductsService(productsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<products> getAllProducts() {
        log.info("Fetching all products");
        return productsRepository.findAll();
    }

    public Optional<products> getProductById(int id) {
        log.info("Fetching product with ID: {}", id);
        return productsRepository.findById(id);
    }

    public List<products> getProductsByCategoryId(int categoryId) {
        log.info("Fetching products for category ID: {}", categoryId);
        return productsRepository.getProductsByCategoryId(categoryId);
    }
}
