package xyz.xkicken.Grocery.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.xkicken.Grocery.repository.CategoryRepository;
import xyz.xkicken.Grocery.model.category;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public List<category> getCategories() {
        return categoryRepository.GetAllCategory();
    }
}
