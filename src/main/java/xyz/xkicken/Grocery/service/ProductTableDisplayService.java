package xyz.xkicken.Grocery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.jdbcRepository.jdbcProductTableDisplayRepository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

import java.util.List;

@Service
public class ProductTableDisplayService {
    private static final Logger log = LoggerFactory.getLogger(ProductTableDisplayService.class);
    private final jdbcProductTableDisplayRepository jdbcProductTableView;

    public ProductTableDisplayService(jdbcProductTableDisplayRepository jdbcProductTableView) {
        this.jdbcProductTableView = jdbcProductTableView;
    }

    public List<ProductsTableDisplay> getAllProducts() {
        log.info("Fetching all products");
        return jdbcProductTableView.findAll();
    }
}
