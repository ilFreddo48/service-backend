package com.inditex.prueba.infra.adapter.output.brand;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.adapter.entity.BrandEntity;
import com.inditex.prueba.infra.adapter.entity.PriceEntity;
import com.inditex.prueba.infra.adapter.entity.ProductEntity;
import com.inditex.prueba.util.mapper.BrandMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandH2AdapterTest {

    @Mock
    private BrandH2Repository mockBrandH2Repository;
    @Mock
    private BrandMapper mockBrandMapper;

    @InjectMocks
    private BrandH2Adapter brandH2AdapterUnderTest;

    @Test
    void testGetBrandByID() {
        // Setup
        final Brand expectedResult = new Brand();
        expectedResult.setId(0);
        expectedResult.setName("name");

        // Configure BrandH2Repository.getById(...).
        final BrandEntity brandEntity = new BrandEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                        new ProductEntity(0, "name", List.of()), null)));
        when(mockBrandH2Repository.getById(0)).thenReturn(brandEntity);

        // Configure BrandMapper.toBrand(...).
        final Brand brand = new Brand();
        brand.setId(0);
        brand.setName("name");
        when(mockBrandMapper.toBrand(new BrandEntity(0, "name",
                List.of(new PriceEntity(0, "startDate", "endDate", 0, 0L, "currency",
                        new ProductEntity(0, "name", List.of()), null))))).thenReturn(brand);

        // Run the test
        final Brand result = brandH2AdapterUnderTest.getBrandByID("id");

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
