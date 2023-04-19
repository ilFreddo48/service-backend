package com.inditex.prueba.application;

import com.inditex.prueba.domain.Brand;
import com.inditex.prueba.domain.Price;
import com.inditex.prueba.exception.InvalidDateFormatException;
import com.inditex.prueba.infra.port.input.PriceInputPort;
import com.inditex.prueba.infra.port.output.PriceRepository;
import com.inditex.prueba.util.Constants;
import com.inditex.prueba.util.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class PriceUserCase implements PriceInputPort {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    // Invocation of brand service
    @Autowired
    private BandUserCase bandUserCase;

    @Override
    public Price getProduct(String applicationDate, Integer productID, String brandID) throws InvalidDateFormatException {

        checkDateFormat(applicationDate);

        Price price = this.priceMapper.toPrice(
                this.priceRepository.findPriceByProductID(productID, applicationDate)
        );
        price.setProductId(productID);
        Brand brand = this.bandUserCase.getBrandByID(brandID);
        price.setBrandId(brandID);
        price.setBrandName(Optional.ofNullable(brand).map(Brand::getName).orElse(null));

        return price;
    }

    private void checkDateFormat(String date) throws InvalidDateFormatException {
        try{
            LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
        }catch (Exception e){
            throw new InvalidDateFormatException("el formato de la fecha no es valido");
        }

    }
}
