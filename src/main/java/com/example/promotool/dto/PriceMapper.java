package com.example.promotool.dto;

import com.example.promotool.model.Price;

public class PriceMapper {

    public static PriceDto toPriceDto(Price price) {
        return PriceDto.builder()
                .chainName(price.getChainName())
                .materialId(price.getMaterialId())
                .price(price.getPrice())
                .build();
    }

    public static Price toPrice(PriceDto priceDto) {
        return Price.builder()
                .chainName(priceDto.getChainName())
                .materialId(priceDto.getMaterialId())
                .price(priceDto.getPrice())
                .build();
    }
}
