package xyz.xkicken.Grocery.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.xkicken.Grocery.jdbcRepository.jdbcCategoryRepository;
import xyz.xkicken.Grocery.repository.CategoryRepository;
import xyz.xkicken.Grocery.model.category;

import java.util.List;

@Service
public class CategoryService implements CategoryRepository {

    private final static Logger log = LoggerFactory.getLogger(CategoryService.class);
    private final jdbcCategoryRepository jdbcCategoryRepository;

    public CategoryService(jdbcCategoryRepository jdbcCategoryRepository) {
        this.jdbcCategoryRepository = jdbcCategoryRepository;
    }

    @Override
    public List<category> GetAllCategory() {
        log.info("Fetching all categories");
        return jdbcCategoryRepository.findAll();
    }


}
