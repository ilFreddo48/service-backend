package com.inditex.prueba.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {

        private String startDate;
        private String endDate;
        private Integer priceList;
        private Integer productId;
        private Integer priority;
        private Long price;
        private String currency;
        private String brandId;
        private String brandName;


}
