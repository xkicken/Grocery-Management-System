package xyz.xkicken.Grocery.Products.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.Products.repository.CategoryRepository;
import xyz.xkicken.Grocery.Products.model.Categories;

import java.util.List;

@Service
public class CategoryService{

    private final static Logger log = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Categories> getAllCategory() {
        log.info("Fetching all categories");
        return categoryRepository.findAll();
    }

}
