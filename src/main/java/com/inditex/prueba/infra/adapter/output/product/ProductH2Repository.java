package com.inditex.prueba.infra.adapter.output.product;

import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductH2Repository extends JpaRepository<ProductEntity, Integer> {
}
