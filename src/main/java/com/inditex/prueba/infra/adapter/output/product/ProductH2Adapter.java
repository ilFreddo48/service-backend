package com.inditex.prueba.infra.adapter.output.product;

import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import com.inditex.prueba.infra.port.output.ProductRepository;
import com.inditex.prueba.domain.Product;
import com.inditex.prueba.util.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductH2Adapter implements ProductRepository {

    @Autowired
    private ProductH2Repository productH2Repository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        return productMapper.toProducts(productH2Repository.findAll());
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return Optional.ofNullable(productMapper.toProduct(this.productH2Repository.getById(id)));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity(product.getId(), product.getName(), null);
        productEntity.setPrices(new ArrayList<>());
        return productMapper.toProduct(productH2Repository.save(productEntity));
    }

    @Override
    public void deleteProductById(Integer id) {
    }
}
