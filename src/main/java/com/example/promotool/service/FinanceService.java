package com.example.promotool.service;

import com.example.promotool.dto.PriceDto;

import java.util.List;

public interface FinanceService {
    PriceDto getPrice(String chain, Integer materialId);

    List<PriceDto> getAllPrices();

    PriceDto addNewPrice(PriceDto priceDto);

    PriceDto updatePrice(PriceDto priceDto);

    void deletePrice(String chain, Integer materialId);
}
