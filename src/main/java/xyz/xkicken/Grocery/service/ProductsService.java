package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.model.Products;
import xyz.xkicken.Grocery.repository.CustomProductsRepository;
import xyz.xkicken.Grocery.repository.ProductsRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private static final Logger log = LoggerFactory.getLogger(ProductsService.class);
    private final ProductsRepository productsRepository;  // Inject the repository\
    private final CustomProductsRepository customProductsRepository;

    public ProductsService(ProductsRepository productsRepository,  CustomProductsRepository customProductsRepository) {
        this.productsRepository = productsRepository;
        this.customProductsRepository = customProductsRepository;
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

    public void updateProducts(Products products, int id) {
        if (productsRepository.existsById(id)){

            log.info("Updating product with ID: {}", id);
            customProductsRepository.updateProducts(products, id);
        }
        else{
            log.info("Product with ID: {} does not exist", id);
            throw new IllegalArgumentException("Product with ID: " + id + " does not exist");
        }
    }
}
