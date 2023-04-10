package com.inditex.prueba.infra.port.output;

import com.inditex.prueba.domain.Brand;

public interface BrandRepository {

    Brand getBrandByID(String id);
}
