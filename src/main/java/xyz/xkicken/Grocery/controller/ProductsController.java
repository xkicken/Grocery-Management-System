package xyz.xkicken.Grocery.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayPagingRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsRepository;
import xyz.xkicken.Grocery.Products.model.Products;
import xyz.xkicken.Grocery.Products.service.ProductTableDisplayService;
import xyz.xkicken.Grocery.Products.service.ProductsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
   private final ProductsRepository productsRepository;
   private final ProductsTableDisplayRepository productsTableDisplayRepository;
   private final ProductsTableDisplayPagingRepository productsTableDisplayPagingRepository;
   private final ProductTableDisplayService productTableDisplayService;
   private final ProductsService productsService;

    public ProductsController(ProductsRepository productsRepository ,
                              ProductsTableDisplayRepository productsTableDisplayRepository,
                              ProductsTableDisplayPagingRepository productsTableDisplayPagingRepository,
                              ProductTableDisplayService productTableDisplayService,
                              ProductsService productsService) {
        this.productsRepository = productsRepository;
        this.productsTableDisplayRepository = productsTableDisplayRepository;
        this.productsTableDisplayPagingRepository = productsTableDisplayPagingRepository;
        this.productTableDisplayService = productTableDisplayService;
        this.productsService = productsService;
    };


    @GetMapping("")
    public List<Products> getInventory() {
        return productsRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Products> findById(@PathVariable Integer id) {
        return productsRepository.findById(id);
    }

    @GetMapping({"/category/{id}"})
    public List<Products> findItemByCategory(@PathVariable Integer id) {
        return productsRepository.getProductsByCategoryId(id);
    }

    @GetMapping("/table")
    public List<ProductsTableDisplay> getProductsTableView() {
        return productsTableDisplayRepository.findAll();
    }

    @GetMapping("/table/category/{id}")
    public List<ProductsTableDisplay> getProductsTableViewByCategory(@PathVariable Integer id) {
        return productTableDisplayService.getProductsByCategory(id);
    }

    @GetMapping("/table/{page}/{size}")
    public List<ProductsTableDisplay> getProductsTableViewByPage(@PathVariable Integer page, @PathVariable Integer size) {
        return productTableDisplayService.getProductsTableViewByPage(page, size);
    }

    @GetMapping("/table/category/{id}/{page}/{size}")
    public List<ProductsTableDisplay> getProductsTableViewByCategoryAndPage(@PathVariable Integer id, @PathVariable Integer page, @PathVariable Integer size) {
        return productTableDisplayService.getProductsTableViewByCategoryAndPage(id, page, size);
    }

    @GetMapping("/table/pages/{size}")
    public Integer getTotalPages(@PathVariable Integer size) {
        return productTableDisplayService.getTotalPages(size);
    }

    @GetMapping("/table/pages/category/{id}/{size}")
    public Integer getTotalPagesByCategory(@PathVariable Integer id, @PathVariable Integer size) {
        return productTableDisplayService.getTotalPagesByCategory(id, size);
    }

    @GetMapping("/table/paginated")
    public Page<ProductsTableDisplay> getProductPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(defaultValue = "productName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        boolean ascending = direction.equalsIgnoreCase("asc");
        return productTableDisplayService.getProductsTableView(page, size, sortBy, direction);
    }

    @GetMapping("/table/paginated/category/{id}")
    public Page<ProductsTableDisplay> getProductsByCategoryId(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        boolean ascending = direction.equalsIgnoreCase("asc");
        return productTableDisplayService.getProductsTableViewByCategory(id, page, size, sortBy, direction);
    }

    @GetMapping("/table/paginated/sorted")
    public Iterable<ProductsTableDisplay> getAllSortedProducts(
            @RequestParam(defaultValue = "productName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return productTableDisplayService.getAllSortedProducts(sortBy, direction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProducts(
            @Valid @RequestBody Products product,
            @PathVariable Integer id) {

        productsService.updateProducts(product, id); // Call the service method to update the product
        return ResponseEntity.noContent().build();  // Return 204 No Content on success
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducts(
            @PathVariable Integer id) {
        productsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> createProducts(
            @Valid @RequestBody Products product) {
        productsRepository.save(product);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<Void> createProducts(
//            @PathVariable Integer id) {
//        productsService.createProduct(product, id);
//    }

}
