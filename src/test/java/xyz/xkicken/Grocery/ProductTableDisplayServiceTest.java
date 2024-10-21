package xyz.xkicken.Grocery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;
import xyz.xkicken.Grocery.Products.repository.CustomProductTableDisplayRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayPagingRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsTableDisplayRepository;
import xyz.xkicken.Grocery.Products.service.ProductTableDisplayService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductTableDisplayServiceTest {

    @Mock
    private ProductsTableDisplayRepository productsTableDisplayRepository;

    @Mock
    private ProductsTableDisplayPagingRepository productsTableDisplayPagingRepository;

    @Mock
    private CustomProductTableDisplayRepository customProductTableDisplayRepository;

    @InjectMocks
    private ProductTableDisplayService productTableDisplayService;

    private ProductsTableDisplay product;

    @BeforeEach
    void setUp() {
        // Initializing a sample product with productId set to 300
        product = new ProductsTableDisplay(
                300,         // productId
                "Apple",     // productName
                1,           // categoryId
                "Fruits",    // categoryName
                0.99,        // price
                0.75,        // costPrice
                "kg",        // unitOfMeasure
                10,          // minStockQuantity
                5,           // reorderLevel
                "A1",        // shelfLocation
                "PLU12345",  // pluCode
                "BC123456789"// barcode
        );
    }

    @Test
    void testGetAllProducts() {
        when(productsTableDisplayRepository.findAll()).thenReturn(List.of(product));

        List<ProductsTableDisplay> result = productTableDisplayService.getAllProducts();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(300, result.get(0).productId());
    }

    @Test
    void testGetProductsByCategory() {
        when(productsTableDisplayRepository.findByCategoryId(1)).thenReturn(List.of(product));

        List<ProductsTableDisplay> result = productTableDisplayService.getProductsByCategory(1);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(300, result.get(0).productId());
    }

    @Test
    void testGetProductsTableViewByPage() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<ProductsTableDisplay> page = new PageImpl<>(List.of(product), pageable, 1);

        when(productsTableDisplayPagingRepository.findAll(pageable)).thenReturn(page);

        List<ProductsTableDisplay> result = productTableDisplayService.getProductsTableViewByPage(0, 1);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(300, result.get(0).productId());
    }

    @Test
    void testGetProductsTableViewByCategoryAndPage() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<ProductsTableDisplay> page = new PageImpl<>(List.of(product), pageable, 1);

        when(productsTableDisplayPagingRepository.findByCategoryId(1, pageable)).thenReturn(page);

        List<ProductsTableDisplay> result = productTableDisplayService.getProductsTableViewByCategoryAndPage(1, 0, 1);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(300, result.get(0).productId());
    }

    @Test
    void testGetProductsTableViewWithSorting() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by("productName").ascending());
        Page<ProductsTableDisplay> page = new PageImpl<>(List.of(product), pageable, 1);

        when(productsTableDisplayPagingRepository.findAll(pageable)).thenReturn(page);

        Page<ProductsTableDisplay> result = productTableDisplayService.getProductsTableView(0, 1, "productName", "asc");
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals(300, result.getContent().get(0).productId());
    }

    @Test
    void testGetProductsTableViewByCategoryWithSorting() {
        Pageable pageable = PageRequest.of(0, 1, Sort.by("productName").ascending());
        Page<ProductsTableDisplay> page = new PageImpl<>(List.of(product), pageable, 1);

        when(productsTableDisplayPagingRepository.findByCategoryId(1, pageable)).thenReturn(page);

        Page<ProductsTableDisplay> result = productTableDisplayService.getProductsTableViewByCategory(1, 0, 1, "productName", "asc");
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals(300, result.getContent().get(0).productId());
    }

    @Test
    void testGetProductsTableViewBySearch() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<ProductsTableDisplay> page = new PageImpl<>(List.of(product), pageable, 1);

        when(productsTableDisplayPagingRepository.findByProductNameContainingIgnoreCase("Apple", pageable)).thenReturn(page);

        Page<ProductsTableDisplay> result = productTableDisplayService.getProductsTableViewBySearch(0, 1, "Apple");
        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals(300, result.getContent().get(0).productId());
    }

    @Test
    void testGetAllSortedProducts() {
        when(productsTableDisplayRepository.findAll(Sort.by("productName").ascending())).thenReturn(List.of(product));

        Iterable<ProductsTableDisplay> result = productTableDisplayService.getAllSortedProducts("productName", "asc");
        assertNotNull(result);
        assertEquals(300, result.iterator().next().productId());
    }

}
