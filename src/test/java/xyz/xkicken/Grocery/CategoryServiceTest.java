package xyz.xkicken.Grocery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.xkicken.Grocery.Products.model.Categories;
import xyz.xkicken.Grocery.Products.repository.CategoryRepository;
import xyz.xkicken.Grocery.Products.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Categories category;

    @BeforeEach
    void setUp() {
        // Initializing a sample category with updated model
        category = new Categories(
                1,           // category_id
                "Fruits"     // category_name
        );
    }

    @Test
    void testGetAllCategory() {
        List<Categories> categoryList = new ArrayList<>();
        categoryList.add(category);

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<Categories> result = categoryService.getAllCategory();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Fruits", result.get(0).category_name());
        assertEquals(1, result.get(0).category_id());
    }
}
