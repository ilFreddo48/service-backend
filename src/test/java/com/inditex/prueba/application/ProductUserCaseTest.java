package com.inditex.prueba.application;

import com.inditex.prueba.domain.Product;
import com.inditex.prueba.infra.port.output.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductUserCaseTest {

    @Mock
    private ProductRepository mockProductRepository;

    @InjectMocks
    private ProductUserCase productUserCaseUnderTest;

    @Test
    void testCreateProduct() {
        // Setup
        final Product expectedResult = new Product();
        expectedResult.setId(0);
        expectedResult.setName("name");

        // Configure ProductRepository.saveProduct(...).
        final Product product = new Product();
        product.setId(0);
        product.setName("name");
        when(mockProductRepository.saveProduct(new Product())).thenReturn(product);

        // Run the test
        final Product result = productUserCaseUnderTest.createProduct(LocalDateTime.of(2020, 1, 1, 0, 0, 0), 0,
                "brandID");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetProduct() {
        // Setup
        // Configure ProductRepository.getProduct(...).
        final Product product1 = new Product();
        product1.setId(0);
        product1.setName("name");
        final Optional<Product> product = Optional.of(product1);
        when(mockProductRepository.getProduct(0)).thenReturn(product);

        // Run the test
        final Product result = productUserCaseUnderTest.getProduct(LocalDateTime.of(2020, 1, 1, 0, 0, 0), 0, "brandID");

        // Verify the results
        assertNull(result);
    }

    @Test
    void testGetProduct_ProductRepositoryReturnsNull() {
        // Setup
        when(mockProductRepository.getProduct(0)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(NoSuchElementException.class,
                () -> productUserCaseUnderTest.getProduct(LocalDateTime.of(2020, 1, 1, 0, 0, 0), 0, "brandID"));
    }
}
