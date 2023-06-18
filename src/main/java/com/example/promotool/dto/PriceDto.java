package com.example.promotool.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDto {
    private String chainName;
    private Integer materialId;
    private Double price;
}
