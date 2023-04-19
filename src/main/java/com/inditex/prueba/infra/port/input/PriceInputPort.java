package com.inditex.prueba.infra.port.input;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.exception.InvalidDateFormatException;

import java.time.LocalDateTime;

public interface PriceInputPort {

    public Price getProduct(String applicationDate, Integer productID, String brandID) throws InvalidDateFormatException;

}
