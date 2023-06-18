package com.example.promotool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @Column(name = "material_id")
    private Integer materialId;
    @Column(name = "material_desc")
    private String materialDescription;
    @Column(name = "category_code")
    private Integer categoryCode;
    @Column(name = "category_name")
    private String categoryName;
}
