package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.model.Products;
import xyz.xkicken.Grocery.repository.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final ProductsRepository productsRepository;  // Inject the repository

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAllProducts() {
        log.info("Fetching all products");
        return productsRepository.findAll();
    }

    public Optional<Products> getProductById(int id) {
        log.info("Fetching product with ID: {}", id);
        return productsRepository.findById(id);
    }

    public List<Products> getProductsByCategoryId(int categoryId) {
        log.info("Fetching products for category ID: {}", categoryId);
        return productsRepository.getProductsByCategoryId(categoryId);
    }
}
