package com.inditex.prueba.infra.port.output;

import com.inditex.prueba.infra.adapter.entity.PriceEntity;

import java.util.List;
import java.util.Optional;

public interface PriceRepository {

    List<PriceEntity> getPrices();
    Optional<PriceEntity> getPrice (Integer id);
    PriceEntity savePrice (PriceEntity product);
    void deletePriceById(Integer id);
    PriceEntity findPriceByProductID(Integer productID, String applicationDate);

}
