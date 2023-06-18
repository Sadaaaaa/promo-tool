package com.example.promotool.dao;

import com.example.promotool.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    Optional<Price> findByChainNameAndMaterialId(String chain, Integer materialId);
}
