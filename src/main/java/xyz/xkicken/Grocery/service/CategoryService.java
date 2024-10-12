package xyz.xkicken.Grocery.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.repository.CategoryRepository;
import xyz.xkicken.Grocery.model.Categories;

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
