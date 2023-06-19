package com.example.promotool.service;

import com.example.promotool.dto.ActualByDaysDto;
import com.example.promotool.dto.ActualPromoDto;
import com.example.promotool.dto.RequestDto;

import java.util.List;

public interface AnalysisService {
    List<ActualPromoDto> getPromo();

    List<ActualByDaysDto> getFactsByDay(RequestDto requestDto);
}
