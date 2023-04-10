package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Price;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceEntity toPriceEntity(Price price);
    Price toPrice(PriceEntity priceEntity);

}
