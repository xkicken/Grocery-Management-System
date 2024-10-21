package xyz.xkicken.Grocery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.xkicken.Grocery.Products.model.Products;
import xyz.xkicken.Grocery.Products.repository.CustomProductsRepository;
import xyz.xkicken.Grocery.Products.repository.ProductsRepository;
import xyz.xkicken.Grocery.Products.service.ProductsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceTest {

    @Mock
    private ProductsRepository productsRepository;

    @Mock
    private CustomProductsRepository customProductsRepository;

    @InjectMocks
    private ProductsService productsService;

    private Products product;

    @BeforeEach
    void setUp() {
        // Initializing a sample product with productId changed to 300
        product = new Products(
                300,          // productId set to 300
                "Apple",      // productName
                1,            // categoryId
                0.99,         // price
                10,           // minStockQuantity
                0.75,         // costPrice
                5.00,         // reorderLevel
                "kg",         // unitOfMeasure
                "A1",         // shelfLocation
                "PLU12345",   // pluCode
                "BC123456789",// barcode
                true,         // isActive
                "2024-10-21", // dateAdded
                1             // version
        );
    }

    @Test
    void testGetAllProducts() {
        List<Products> productList = new ArrayList<>();
        productList.add(product);

        when(productsRepository.findAll()).thenReturn(productList);

        List<Products> result = productsService.getAllProducts();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Apple", result.get(0).productName());
    }

    @Test
    void testGetProductByIdFound() {
        when(productsRepository.findById(300)).thenReturn(Optional.of(product));

        Optional<Products> result = productsService.getProductById(300);
        assertTrue(result.isPresent());
        assertEquals("Apple", result.get().productName());
    }

    @Test
    void testUpdateProducts() {
        when(productsRepository.existsById(300)).thenReturn(true);

        productsService.updateProducts(product, 300);
        verify(customProductsRepository, times(1)).updateProducts(product, 300);
    }


    @Test
    void testDeleteProducts() {
        when(productsRepository.existsById(300)).thenReturn(true);

        productsService.deleteProducts(300);
        verify(customProductsRepository, times(1)).deleteProducts(300);
    }

}
