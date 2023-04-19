package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandMapperImplTest {

    private BrandMapperImpl brandMapperImplUnderTest;

    @BeforeEach
    void setUp() {
        brandMapperImplUnderTest = new BrandMapperImpl();
    }

    @Test
    void testToBrand() {
        // Setup
        final BrandEntity brandEntity = new BrandEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                        new ProductEntity(0, "name", List.of()), null)));
        final Brand expectedResult = new Brand();
        expectedResult.setId(0);
        expectedResult.setName("name");

        // Run the test
        final Brand result = brandMapperImplUnderTest.toBrand(brandEntity);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testToEntity() {
        // Setup
        final Brand barnd = new Brand();
        barnd.setId(0);
        barnd.setName("name");

        final BrandEntity expectedResult = new BrandEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                        new ProductEntity(0, "name", List.of()), null)));

        // Run the test
        final BrandEntity result = brandMapperImplUnderTest.toEntity(barnd);

        // Verify the results
        assertEquals(expectedResult.getId(), result.getId());
        assertEquals(expectedResult.getName(), result.getName());
    }
}
