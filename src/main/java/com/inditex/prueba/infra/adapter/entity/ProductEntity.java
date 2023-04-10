package com.inditex.prueba.infra.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@AllArgsConstructor // para que funcione las validaciones
@NoArgsConstructor // para que no de error al obtener el producto con el getProduct(Integer id)
@Data //getter y setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "product")
    private List<PriceEntity> prices = new ArrayList<>();

}
