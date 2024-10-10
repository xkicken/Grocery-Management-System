package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.repository.ProductsTableDisplayPagingRepository;
import xyz.xkicken.Grocery.repository.ProductsTableDisplayRepository;

import java.util.List;

@Service
public class ProductTableDisplayService {
    private static final Logger log = LoggerFactory.getLogger(ProductTableDisplayService.class);
    private final ProductsTableDisplayRepository productsTableDisplayRepository;
    private final ProductsTableDisplayPagingRepository  productsTableDisplayPagingRepository;

    public ProductTableDisplayService(ProductsTableDisplayRepository productsTableDisplayRepository, ProductsTableDisplayPagingRepository productsTableDisplayPagingRepository) {
        this.productsTableDisplayRepository = productsTableDisplayRepository;
        this.productsTableDisplayPagingRepository = productsTableDisplayPagingRepository;
    }

    public List<ProductsTableDisplay> getAllProducts() {
        log.info("Fetching all products");
        return productsTableDisplayRepository.findAll();
    }

    public List<ProductsTableDisplay> getProductsTableViewByPage(int page, int size) {
        log.info("Fetching products for page: {}, size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return productsTableDisplayPagingRepository.findAll(pageable).getContent();
    }

    public List<ProductsTableDisplay> getProductsByCategory(int id) {
        log.info("Fetching products by category: {}", id);
        return productsTableDisplayRepository.findByCategoryId(id);
    }

    public int getTotalPages(int pageSize) {
        long totalProducts = productsTableDisplayRepository.count();
        log.info("Total products: {}", totalProducts);
        return (int) Math.ceil((double) totalProducts / pageSize);
    }
}
