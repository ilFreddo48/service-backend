package com.inditex.prueba.infra.adapter.input.rest.response;

import com.inditex.prueba.infra.adapter.input.rest.request.PriceRequest;
import lombok.Data;

@Data
public class PriceResponse extends PriceRequest {

    private Integer priceId;
    private Long price;

}
