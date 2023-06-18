package com.example.promotool.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestDto {
    private List<String> chains;
    private List<Integer> materialIds;
}
