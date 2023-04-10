package com.inditex.prueba.infra.port.output;

import com.inditex.prueba.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getProducts();
    Optional<Product> getProduct (Integer id);
    Product saveProduct (Product product);
    void deleteProductById(Integer id);
}
