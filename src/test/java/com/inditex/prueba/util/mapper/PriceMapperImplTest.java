package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperImplTest {

    private PriceMapperImpl priceMapperImplUnderTest;

    @BeforeEach
    void setUp() {
        priceMapperImplUnderTest = new PriceMapperImpl();
    }

    @Test
    void testToPriceEntity() {
        // Setup
        final Price price = new Price();
        price.setStartDate("startDate");
        price.setEndDate("endDate");
        price.setPriceList(0);
        price.setProductId(0);
        price.setPriority(0);
        price.setPrice(0L);
        price.setCurrency("currency");
        price.setBrandId("brandId");
        price.setBrandName("brandName");

        final PriceEntity expectedResult = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));

        // Run the test
        final PriceEntity result = priceMapperImplUnderTest.toPriceEntity(price);

        // Verify the results
        assertEquals(expectedResult.getPriceList(), result.getPriceList());
    }

    @Test
    void testToPrice() {
        // Setup
        final PriceEntity priceEntity = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));
        final Price expectedResult = new Price();
        expectedResult.setStartDate("startDate");
        expectedResult.setEndDate("endDate");
        expectedResult.setPriceList(0);
        expectedResult.setProductId(0);
        expectedResult.setPriority(0);
        expectedResult.setPrice(0L);
        expectedResult.setCurrency("currency");
        expectedResult.setBrandId("brandId");
        expectedResult.setBrandName("brandName");

        // Run the test
        final Price result = priceMapperImplUnderTest.toPrice(priceEntity);

        // Verify the results
        assertEquals(expectedResult.getPriceList(), result.getPriceList());
    }
}
