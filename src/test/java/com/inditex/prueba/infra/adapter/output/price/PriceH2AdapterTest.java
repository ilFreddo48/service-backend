package com.inditex.prueba.infra.adapter.output.price;

import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceH2AdapterTest {

    @Mock
    private PriceH2Repository mockPriceH2Repository;

    @InjectMocks
    private PriceH2Adapter priceH2AdapterUnderTest;

    @Test
    void testGetPrices() {
        assertNull(priceH2AdapterUnderTest.getPrices());
    }

    @Test
    void testGetPrice() {
        // Setup
        final Optional<PriceEntity> expectedResult = Optional.of(
                new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", new ProductEntity(0, "name", List.of()),
                        new BrandEntity(0, "name", List.of())));

        // Configure PriceH2Repository.getById(...).
        final PriceEntity priceEntity = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));
        when(mockPriceH2Repository.getById(0)).thenReturn(priceEntity);

        // Run the test
        final Optional<PriceEntity> result = priceH2AdapterUnderTest.getPrice(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetPrice_PriceH2RepositoryReturnsNull() {
        // Setup
        when(mockPriceH2Repository.getById(0)).thenReturn(null);

        // Run the test
        final Optional<PriceEntity> result = priceH2AdapterUnderTest.getPrice(0);

        // Verify the results
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testFindPriceByProductID() {
        // Setup
        final PriceEntity expectedResult = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));

        // Configure PriceH2Repository.findPriceByProductID(...).
        final PriceEntity priceEntity = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));
        when(mockPriceH2Repository.findPriceByProductID(0, "applicationDate")).thenReturn(priceEntity);

        // Run the test
        final PriceEntity result = priceH2AdapterUnderTest.findPriceByProductID(0, "applicationDate");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testSavePrice() {
        assertNull(priceH2AdapterUnderTest.savePrice(
                new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", new ProductEntity(0, "name", List.of()),
                        new BrandEntity(0, "name", List.of()))));
    }

    @Test
    void testDeletePriceById() {
        // Setup
        // Run the test
        priceH2AdapterUnderTest.deletePriceById(0);

        // Verify the results
    }
}
