package com.inditex.prueba.application;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.infra.port.output.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BandUserCaseTest {

    @Mock
    private BrandRepository mockBrandRepository;

    @InjectMocks
    private BandUserCase bandUserCaseUnderTest;

    @Test
    void testGetBrandByID() {
        // Setup
        final Brand expectedResult = new Brand();
        expectedResult.setId(0);
        expectedResult.setName("name");

        // Configure BrandRepository.getBrandByID(...).
        final Brand brand = new Brand();
        brand.setId(0);
        brand.setName("name");
        when(mockBrandRepository.getBrandByID("id")).thenReturn(brand);

        // Run the test
        final Brand result = bandUserCaseUnderTest.getBrandByID("id");

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
