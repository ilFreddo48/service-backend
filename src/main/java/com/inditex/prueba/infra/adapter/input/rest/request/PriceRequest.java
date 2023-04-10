package com.inditex.prueba.infra.adapter.input.rest.request;

import lombok.Data;

@Data
public class PriceRequest {

    private String applicationDate;
    private Integer productID;
    private String brandID;

}
