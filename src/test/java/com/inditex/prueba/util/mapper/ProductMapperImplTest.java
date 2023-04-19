package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Product;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperImplTest {

    private ProductMapperImpl productMapperImplUnderTest;

    @BeforeEach
    void setUp() {
        productMapperImplUnderTest = new ProductMapperImpl();
    }

    @Test
    void testToProduct() {
        // Setup
        final ProductEntity productEntity = new ProductEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", null,
                        new BrandEntity(0, "name", List.of()))));
        final Product expectedResult = new Product();
        expectedResult.setId(0);
        expectedResult.setName("name");

        // Run the test
        final Product result = productMapperImplUnderTest.toProduct(productEntity);

        // Verify the results
        assertEquals(expectedResult.getId(), result.getId());
    }

    @Test
    void testToProducts() {
        // Setup
        final List<ProductEntity> productEntity = List.of(new ProductEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", null,
                        new BrandEntity(0, "name", List.of())))));
        final Product product = new Product();
        product.setId(0);
        product.setName("name");
        final List<Product> expectedResult = List.of(product);

        // Run the test
        final List<Product> result = productMapperImplUnderTest.toProducts(productEntity);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testToProductEntity() {
        // Setup
        final Product product = new Product();
        product.setId(0);
        product.setName("name");

        final ProductEntity expectedResult = new ProductEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", null,
                        new BrandEntity(0, "name", List.of()))));

        // Run the test
        final ProductEntity result = productMapperImplUnderTest.toProductEntity(product);

        // Verify the results
        assertEquals(expectedResult.getId(), result.getId());
    }
}
