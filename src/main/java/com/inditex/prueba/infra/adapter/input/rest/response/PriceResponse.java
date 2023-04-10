package com.inditex.prueba.infra.adapter.input.rest.response;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.input.rest.request.PriceRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceResponse extends PriceRequest {

    private Integer priceId;
    private Long price;


    public static String createResponse(Price price) {
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int day = LocalDateTime.now().getDayOfMonth();
        String s = "Test 1: petición a las "+hour+":"+minute+" del día "+ day+" del producto " + price.getProductId() + " 35455 para la brand " + price.getBrandId() + " (" + price.getBrandName() + ")";
        return s;
    }
}
