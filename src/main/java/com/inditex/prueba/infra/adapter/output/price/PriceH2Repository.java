package com.inditex.prueba.infra.adapter.output.price;

import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceH2Repository extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT p FROM PriceEntity p WHERE p.priceList = ?1 AND p.startDate = ?2 ORDER BY p.priority DESC LIMIT 1")
    PriceEntity findPriceByProductID(Integer productID, String applicationDate);
}
