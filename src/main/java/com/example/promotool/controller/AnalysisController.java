package com.example.promotool.controller;

import com.example.promotool.dto.RequestDto;
import com.example.promotool.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnalysisController {

    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("promo")
    public ResponseEntity<?> getPromo() {
        return ResponseEntity.ok(analysisService.getPromo());
    }

    @GetMapping("facts")
    public ResponseEntity<?> getFactsByDay(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(analysisService.getFactsByDay(requestDto));
    }

}
