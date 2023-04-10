package com.inditex.prueba.infra.adapter.input.rest.response;

import com.inditex.prueba.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PriceResponseTest {

    private PriceResponse priceResponseUnderTest;

    @BeforeEach
    void setUp() {
        priceResponseUnderTest = new PriceResponse();
    }


    @Test
    void testCreateResponse() {
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

        // Run the test
        final String result = PriceResponse.createResponse(price);
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int day = LocalDateTime.now().getDayOfMonth();
        String s = "Test 1: petición a las "+hour+":"+minute+" del día "+ day+" del producto " + price.getProductId() + " 35455 para la brand " + price.getBrandId() + " (" + price.getBrandName() + ")";

        // Verify the results
        assertEquals(s, result);
    }
}
