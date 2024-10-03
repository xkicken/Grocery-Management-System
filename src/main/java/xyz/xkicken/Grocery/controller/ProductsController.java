package xyz.xkicken.Grocery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.repository.ProductsTableDisplayRepository;
import xyz.xkicken.Grocery.repository.productsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.xkicken.Grocery.model.products;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
   private final productsRepository productsRepository;
   private final ProductsTableDisplayRepository productsTableDisplayRepository;

    public ProductsController(productsRepository productsRepository , ProductsTableDisplayRepository productsTableDisplayRepository) {
        this.productsRepository = productsRepository;
        this.productsTableDisplayRepository = productsTableDisplayRepository;

    };


    @GetMapping("")
    public List<products> getInventory() {
        return productsRepository.getAllProducts();
    }

    @GetMapping({"/{id}"})
    public Optional<products> findById(@PathVariable Integer id) {
        return productsRepository.getProductById(id);
    }

    @GetMapping({"/category/{id}"})
    public List<products> findItemByCategory(@PathVariable Integer id) {
        return productsRepository.getProductsByCategoryId(id);
    }

    @GetMapping("/table")
    public List<ProductsTableDisplay> getProductsTableView() {
        return productsTableDisplayRepository.findAll();
    }

}
