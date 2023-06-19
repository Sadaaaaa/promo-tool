package com.example.promotool.dto;

import com.example.promotool.model.Customers;
import com.example.promotool.model.Products;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
public class ActualByDaysDto {

    private LocalDate date;
    private Integer materialId;
    private Integer shipToCode;
    private String chain;
    private Integer volumeUnits;
    private Double actualSalesValue;
    private String promo;
    private Customers customer;
    private Products products;

}
