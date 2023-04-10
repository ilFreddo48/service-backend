package com.inditex.prueba.infra.adapter.output.brand;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.port.output.BrandRepository;
import com.inditex.prueba.util.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandH2Adapter implements BrandRepository {

    @Autowired
    private BrandH2Repository brandH2Repository;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand getBrandByID(String id) {

        return brandMapper.toBrand(this.brandH2Repository.getById(new Integer(id)));
    }
}
