package com.example.promotool.service;

import com.example.promotool.dao.PriceRepository;
import com.example.promotool.dto.PriceDto;
import com.example.promotool.dto.PriceMapper;
import com.example.promotool.exception.NotFoundException;
import com.example.promotool.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceServiceImpl implements FinanceService {


    private final PriceRepository priceRepository;

    @Autowired
    public FinanceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDto getPrice(String chain, Integer materialId) {
        Price price = priceRepository.findByChainNameAndMaterialId(chain, materialId)
                .orElseThrow(() -> new NotFoundException("Item is not found"));
        return PriceMapper.toPriceDto(price);
    }

    @Override
    public List<PriceDto> getAllPrices() {
        List<Price> prices = priceRepository.findAll();
        if (prices.size() > 0) {
            return prices.stream().map(PriceMapper::toPriceDto).collect(Collectors.toList());

        }

        return new ArrayList<>();
    }

    @Override
    public PriceDto addNewPrice(PriceDto priceDto) {
        Price price = priceRepository.save(PriceMapper.toPrice(priceDto));
        return PriceMapper.toPriceDto(price);
    }

    @Override
    public PriceDto updatePrice(PriceDto priceDto) {
        Price priceToUpdate = priceRepository.findByChainNameAndMaterialId(priceDto.getChainName(), priceDto.getMaterialId())
                .orElseThrow(() -> new NotFoundException("Item is not found"));

        if (priceToUpdate != null) {
            priceToUpdate.setPrice(priceDto.getPrice());

            return PriceMapper.toPriceDto(priceRepository.save(priceToUpdate));
        }

        return null;
    }

    @Override
    public void deletePrice(String chain, Integer materialId) {
        Price price = priceRepository.findByChainNameAndMaterialId(chain, materialId)
                .orElseThrow(() -> new NotFoundException("Item is not found"));

        if (price != null) {
            priceRepository.delete(price);
        }
    }
}
