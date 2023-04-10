package com.inditex.prueba.infra.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRICES")
@AllArgsConstructor // para que funcione las validaciones
@NoArgsConstructor // para que no de error al obtener el producto con el getProduct(Integer id)
@Data //getter y setter
public class PriceEntity {

    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    private Integer priority;
    private Long price;
    @Column(name = "CURR")
    private String currency;


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductEntity product;


    /*@ManyToMany
    @JoinTable(
            name = "PRICES_BRANDS",
            joinColumns = @JoinColumn(name = "PRICE_LIST", referencedColumnName = "PRICE_LIST"),
            inverseJoinColumns = @JoinColumn(name = "BRANDS_ID", referencedColumnName = "ID")
    )
    private List<BrandEntity> brands = new ArrayList<>();*/
    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private BrandEntity brand;

}
