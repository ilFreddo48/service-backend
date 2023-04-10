package com.inditex.prueba.infra.port.input;

import com.inditex.prueba.domain.Brand;

public interface BrandInputPort {

    Brand getBrandByID(String id);
}
