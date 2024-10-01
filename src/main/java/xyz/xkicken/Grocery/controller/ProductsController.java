package xyz.xkicken.Grocery.controller;

import org.springframework.web.bind.annotation.PathVariable;
import xyz.xkicken.Grocery.products.productsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.xkicken.Grocery.products.products;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

   private final productsRepository productsRepository;

    public ProductsController(productsRepository productsRepository) {
        this.productsRepository = productsRepository;

    };


    @GetMapping("")
    public List<products> getInventory() {
        return productsRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public Optional<products> findById(@PathVariable Integer id) {
        return productsRepository.findById(id);
    }

    @GetMapping({"/category/{id}"})
    public List<products> findItemByCategory(@PathVariable Integer id) {
        return productsRepository.findBycategoryId(id);
    }

}
