package com.inditex.prueba.util.mapper;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toBrand(BrandEntity brandEntity);
    BrandEntity toEntity(Brand barnd);
}
