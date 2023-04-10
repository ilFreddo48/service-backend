package com.inditex.prueba.application;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.port.input.BrandInputPort;
import com.inditex.prueba.infra.port.output.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BandUserCase implements BrandInputPort {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand getBrandByID(String id) {
        return this.brandRepository.getBrandByID(id);
    }
}
