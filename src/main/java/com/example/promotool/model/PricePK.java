package com.example.promotool.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PricePK implements Serializable {
    private String chainName;
    private Integer materialId;

    public PricePK(String chainName, Integer materialId) {
        this.chainName = chainName;
        this.materialId = materialId;
    }

    public PricePK() {

    }
}
