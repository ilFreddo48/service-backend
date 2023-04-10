package com.inditex.prueba.infra.adapter.input.rest.controller;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.input.rest.request.PriceRequest;
import com.inditex.prueba.infra.port.input.PriceInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceApiTest {

    @Mock
    private PriceInputPort mockPriceInputPort;

    @InjectMocks
    private PriceApi priceApiUnderTest;

    @Test
    void testCreateProduct() {
        // Setup
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

        // Configure PriceInputPort.getProduct(...).
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
        when(mockPriceInputPort.getProduct("applicationDate", 0, "brandID")).thenReturn(price);

        // Run the test
        final Price result = priceApiUnderTest.createProduct("applicationDate", 0, "brandID");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAppliedPrice() throws Exception {
        // Setup
        final PriceRequest request = new PriceRequest();
        request.setApplicationDate("applicationDate");
        request.setProductID(0);
        request.setBrandID("brandID");

        // Configure PriceInputPort.getProduct(...).
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
        when(mockPriceInputPort.getProduct("applicationDate", 0, "brandID")).thenReturn(price);

        // Run the test
        final ResponseEntity result = priceApiUnderTest.getAppliedPrice(request);

        // Verify the results
        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}
