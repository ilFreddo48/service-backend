package com.inditex.prueba.infra.adapter.input.rest.controller;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.input.rest.request.PriceRequest;
import com.inditex.prueba.infra.adapter.input.rest.response.PriceResponse;
import com.inditex.prueba.infra.port.input.PriceInputPort;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
@Slf4j
public class PriceApi {

    @Autowired
    private PriceInputPort priceInputPort;

    @Operation(summary = "Get appllied price by date, producIt and brandId")
    @PostMapping(value = "", headers = "content-type=application/json", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAppliedPrice(@RequestBody PriceRequest request) throws Exception{

        log.info("request : " + request.toString());

        Price price = this.priceInputPort.getProduct(request.getApplicationDate(), request.getProductID(), request.getBrandID());

        return ResponseEntity.status(HttpStatus.OK).body(PriceResponse.createResponse(price));
    }

}
