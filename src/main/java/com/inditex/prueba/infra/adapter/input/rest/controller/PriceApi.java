package com.inditex.prueba.infra.adapter.input.rest.controller;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.domain.Product;
import com.inditex.prueba.infra.adapter.input.rest.request.PriceRequest;
import com.inditex.prueba.infra.adapter.input.rest.response.PriceResponse;
import com.inditex.prueba.infra.port.input.PriceInputPort;
import com.inditex.prueba.infra.port.input.ProductInputport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/price")
@Slf4j
public class PriceApi {

    @Autowired
    private PriceInputPort priceInputPort;


    @PostMapping(value = "", headers = "content-type=application/json", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAppliedPrice(@RequestBody PriceRequest request) throws Exception{

        log.info("request : " + request.toString());

        Price price = this.priceInputPort.getProduct(request.getApplicationDate(), request.getProductID(), request.getBrandID());
        return ResponseEntity.status(HttpStatus.OK).body(PriceResponse.createResponse(price));
    }

}
