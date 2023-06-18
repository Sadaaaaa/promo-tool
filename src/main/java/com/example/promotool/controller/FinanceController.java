package com.example.promotool.controller;

import com.example.promotool.dto.PriceDto;
import com.example.promotool.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    private final FinanceService financeService;

    @Autowired
    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping
    public ResponseEntity<?> getPrice(@RequestParam(value = "chain", required = false) String chain,
                                      @RequestParam(value = "materialId", required = false) Integer materialId) {
        return ResponseEntity.ok(financeService.getPrice(chain, materialId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPrices() {
        return ResponseEntity.ok(financeService.getAllPrices());
    }

    @PostMapping
    public ResponseEntity<?> addNewPrice(@RequestBody PriceDto priceDto) {
        return ResponseEntity.ok(financeService.addNewPrice(priceDto));
    }

    @PatchMapping
    public ResponseEntity<?> updatePrice(@RequestBody PriceDto priceDto) {
        return ResponseEntity.ok(financeService.updatePrice(priceDto));
    }

    @DeleteMapping
    public void deletePrice(@RequestParam(value = "chain", required = false) String chain,
                            @RequestParam(value = "materialId", required = false) Integer materialId) {
        financeService.deletePrice(chain, materialId);
    }
}
