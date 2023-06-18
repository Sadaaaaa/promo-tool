package com.example.promotool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "price")
@IdClass(PricePK.class)
public class Price {
    @Id
    @Column(name = "chain_name")
    private String chainName;
    @Id
    @Column(name = "material_no")
    private Integer materialId;
    @Column(name = "regular_price")
    private Double price;
}
