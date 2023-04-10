package com.inditex.prueba.infra.port.input;

import com.inditex.prueba.domain.Product;

import java.time.LocalDateTime;

public interface ProductInputport {

    public Product createProduct(LocalDateTime applicationDate, Integer productID, String brandID);
    public Product getProduct(LocalDateTime applicationDate, Integer productID, String brandID);


}
