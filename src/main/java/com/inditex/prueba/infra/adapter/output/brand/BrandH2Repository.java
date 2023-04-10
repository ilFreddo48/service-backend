package com.inditex.prueba.infra.adapter.output.brand;

import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandH2Repository extends JpaRepository<BrandEntity, Integer> {
}
