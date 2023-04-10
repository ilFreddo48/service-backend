package com.inditex.prueba.application;

import com.inditex.prueba.domain.Product;
import com.inditex.prueba.infra.port.input.ProductInputport;
import com.inditex.prueba.infra.port.output.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductUserCase implements ProductInputport {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(LocalDateTime applicationDate, Integer productID, String brandID) {
        Product product = new Product();
        product.setId(productID);
        return productRepository.saveProduct(product);
    }

    @Override
    public Product getProduct(LocalDateTime applicationDate, Integer productID, String brandID) {

        Product product = Optional.ofNullable(productRepository.getProduct(productID)).map(product1 -> product1.get()).get();


        return null;
    }
}
