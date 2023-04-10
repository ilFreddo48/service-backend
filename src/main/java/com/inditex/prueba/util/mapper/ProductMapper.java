package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Product;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntity);
    ProductEntity toProductEntity(Product product);

}
