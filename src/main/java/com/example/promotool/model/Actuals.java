package com.example.promotool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "actuals")
public class Actuals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "record_date")
    private LocalDate date;
    @Column(name = "material_no")
    private Integer materialId;
    @Column(name = "ship_to_code")
    private Integer shipToCode;
    @Column(name = "chain_name")
    private String chain;
    @Column(name = "volume_units")
    private Integer volumeUnits;
    @Column(name = "actual_sales_value")
    private Double actualSalesValue;
    @Column(name = "promo")
    private String promo;

    @ManyToOne
    @JoinColumn(name = "ship_to_code", referencedColumnName = "ship_to_code", insertable = false, updatable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "material_no", referencedColumnName = "material_id", insertable = false, updatable = false)
    private Products products;
}
