package xyz.xkicken.Grocery.Products.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayPagingRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayRepository;
import xyz.xkicken.Grocery.Products.repository.CustomProductTableDisplayRepository;

import java.util.List;

@Service
public class ProductTableDisplayService {
    private static final Logger log = LoggerFactory.getLogger(ProductTableDisplayService.class);

    private final ProductsTableDisplayRepository productsTableDisplayRepository;
    private final ProductsTableDisplayPagingRepository  productsTableDisplayPagingRepository;
    private final CustomProductTableDisplayRepository customProductTableDisplayRepository;

    @Autowired
    public ProductTableDisplayService(ProductsTableDisplayRepository productsTableDisplayRepository,
                                      ProductsTableDisplayPagingRepository productsTableDisplayPagingRepository,
                                      CustomProductTableDisplayRepository customProductTableDisplayRepository) {
        this.productsTableDisplayRepository = productsTableDisplayRepository;
        this.productsTableDisplayPagingRepository = productsTableDisplayPagingRepository;
        this.customProductTableDisplayRepository = customProductTableDisplayRepository;
    }

    public List<ProductsTableDisplay> getAllProducts() {
        log.info("Fetching all products");
        return productsTableDisplayRepository.findAll();
    }

    public List<ProductsTableDisplay> getProductsByCategory(int id) {
        log.info("Fetching products by category: {}", id);
        return productsTableDisplayRepository.findByCategoryId(id);
    }

    public int getTotalPages(int pageSize) {
        long totalProducts = productsTableDisplayRepository.count();
        return (int) Math.ceil((double) totalProducts / pageSize);
    }

    public int getTotalPagesByCategory(int id, int pageSize) {
        long totalProducts = productsTableDisplayRepository.count();
        return (int) Math.ceil((double) totalProducts / pageSize);
    }

    public List<ProductsTableDisplay> getProductsTableViewByPage(int page, int size) {
        log.info("Fetching products for page: {}, size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return productsTableDisplayPagingRepository.findAll(pageable).getContent();
    }

    public List<ProductsTableDisplay> getProductsTableViewByCategoryAndPage(int id, int page, int size) {
        log.info("Fetching products by category: {}, page: {}, size: {}", id, page, size);
        Pageable pageable = PageRequest.of(page, size);
        return productsTableDisplayPagingRepository.findByCategoryId(id, pageable).getContent();
    }

    public Page<ProductsTableDisplay> getProductsTableView(int page, int size, String sortBy, String direction) {
        if (validateSortQuery(sortBy, direction)){
            log.info("Fetching products for page: {}, size: {}, sortBy: {}, direction: {}", page, size, sortBy, direction);
            Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
            Pageable pageable = PageRequest.of(page, size, sort);
            return productsTableDisplayPagingRepository.findAll(pageable);
        };

        throw new IllegalArgumentException();
    }

    public Page<ProductsTableDisplay> getProductsTableViewByCategory(int id, int page, int size, String sortBy, String direction) {
        if(validateSortQuery(sortBy, direction)){
            log.info("Fetching products by category: {}, page: {}, size: {}, sortBy: {}, direction: {}", id, page, size, sortBy, direction);
            Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
            Pageable pageable = PageRequest.of(page, size, sort);
            return productsTableDisplayPagingRepository.findByCategoryId(id, pageable);
        };
        throw new IllegalArgumentException();
    }

    public Page<ProductsTableDisplay> getProductsTableViewBySearch(int page, int size, String query) {
        log.info("Fetching products by search: {}, page: {}, size: {}", query, page, size);
        Pageable pageable = PageRequest.of(page, size);
        return productsTableDisplayPagingRepository.findByProductNameContainingIgnoreCase(query, pageable);
    }

    public Iterable<ProductsTableDisplay> getAllSortedProducts(String sortBy, String direction) {
        log.info("Fetching all products sorted by: {}, direction: {}", sortBy, direction);
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return productsTableDisplayRepository.findAll(sort);
    }


    //  validate sort and direction input
    private boolean validateSortQuery(String sortBy, String direction) {
        List<String> validSortBy = List.of("productId", "productName", "categoryId", "categoryName", "price", "costPrice", "stockQuantity", "unitOfMeasure", "minStockQuantity", "reorderLevel", "shelfLocation", "pluCode", "barcode", "expirationDate");
        List<String> validDirection = List.of("asc", "desc");
        direction = direction.toLowerCase();

        if (!validSortBy.contains(sortBy)) {
            log.info("Invalid sortBy input={}", sortBy);
            throw new IllegalArgumentException("Invalid sortBy: " + sortBy);
        }
        if (!validDirection.contains(direction)) {
            log.info("invaild direction input={}", direction);
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        return true;
    }

    public List<ProductsTableDisplay> searchProduct(String column, String query){
        log.info("Searching for products with column: {}, query: {}", column, query);
        return customProductTableDisplayRepository.searchProductsByColumn(column, query);
    }
}
