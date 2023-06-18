package com.example.promotool.service;

import com.example.promotool.dto.RequestDto;

public interface AnalysisService {
    Object getPromo();

    Object getFactsByDay(RequestDto requestDto);
}
