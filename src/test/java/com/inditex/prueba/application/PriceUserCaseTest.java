package com.inditex.prueba.application;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import com.inditex.prueba.infra.port.output.PriceRepository;
import com.inditex.prueba.util.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceUserCaseTest {

    @Mock
    private PriceRepository mockPriceRepository;
    @Mock
    private PriceMapper mockPriceMapper;
    @Mock
    private BandUserCase mockBandUserCase;

    @InjectMocks
    private PriceUserCase priceUserCaseUnderTest;

    @Test
    void testGetProduct() {
        // Setup
        final Price expectedResult = new Price();
        expectedResult.setStartDate("startDate");
        expectedResult.setEndDate("endDate");
        expectedResult.setPriceList(0);
        expectedResult.setProductId(0);
        expectedResult.setPriority(0);
        expectedResult.setPrice(0L);
        expectedResult.setCurrency("currency");
        expectedResult.setBrandId("brandID");
        expectedResult.setBrandName("name");

        // Configure PriceRepository.findPriceByProductID(...).
        final PriceEntity priceEntity = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));
        when(mockPriceRepository.findPriceByProductID(0, "applicationDate")).thenReturn(priceEntity);

        // Configure PriceMapper.toPrice(...).
        final Price price = new Price();
        price.setStartDate("startDate");
        price.setEndDate("endDate");
        price.setPriceList(0);
        price.setProductId(0);
        price.setPriority(0);
        price.setPrice(0L);
        price.setCurrency("currency");
        price.setBrandId("brandID");
        price.setBrandName("brandName");
        when(mockPriceMapper.toPrice(
                new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", new ProductEntity(0, "name", List.of()),
                        new BrandEntity(0, "name", List.of())))).thenReturn(price);

        // Configure BandUserCase.getBrandByID(...).
        final Brand brand = new Brand();
        brand.setId(0);
        brand.setName("name");
        when(mockBandUserCase.getBrandByID("brandID")).thenReturn(brand);

        // Run the test
        final Price result = priceUserCaseUnderTest.getProduct("applicationDate", 0, "brandID");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetProduct_BandUserCaseReturnsNull() {
        // Setup
        final Price expectedResult = new Price();
        expectedResult.setStartDate("startDate");
        expectedResult.setEndDate("endDate");
        expectedResult.setPriceList(0);
        expectedResult.setProductId(0);
        expectedResult.setPriority(0);
        expectedResult.setPrice(0L);
        expectedResult.setCurrency("currency");
        expectedResult.setBrandId("brandID");
        //expectedResult.setBrandName("name");

        // Configure PriceRepository.findPriceByProductID(...).
        final PriceEntity priceEntity = new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                new ProductEntity(0, "name", List.of()), new BrandEntity(0, "name", List.of()));
        when(mockPriceRepository.findPriceByProductID(0, "applicationDate")).thenReturn(priceEntity);

        // Configure PriceMapper.toPrice(...).
        final Price price = new Price();
        price.setStartDate("startDate");
        price.setEndDate("endDate");
        price.setPriceList(0);
        price.setProductId(0);
        price.setPriority(0);
        price.setPrice(0L);
        price.setCurrency("currency");
        price.setBrandId("brandID");
        price.setBrandName("brandName");
        when(mockPriceMapper.toPrice(
                new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency", new ProductEntity(0, "name", List.of()),
                        new BrandEntity(0, "name", List.of())))).thenReturn(price);

        when(mockBandUserCase.getBrandByID("brandID")).thenReturn(null);

        // Run the test
        final Price result = priceUserCaseUnderTest.getProduct("applicationDate", 0, "brandID");

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
