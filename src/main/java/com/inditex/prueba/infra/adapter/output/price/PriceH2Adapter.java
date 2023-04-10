package com.inditex.prueba.infra.adapter.output.price;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.port.output.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PriceH2Adapter implements PriceRepository {

    @Autowired
    private PriceH2Repository priceH2Repository;

    @Override
    public List<PriceEntity> getPrices() {
        return null;
    }

    @Override
    public Optional<PriceEntity> getPrice(Integer id) {

        PriceEntity priceEntity = this.priceH2Repository.getById(id);

        return Optional.ofNullable(priceEntity);
    }

    public PriceEntity findPriceByProductID(Integer id, String applicationDate) {

        return this.priceH2Repository.findPriceByProductID(id, applicationDate);

    }

    @Override
    public PriceEntity savePrice(PriceEntity product) {
        return null;
    }

    @Override
    public void deletePriceById(Integer id) {

    }
}
