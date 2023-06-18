package com.example.promotool.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActualPromoDto {
    private String chain; // сеть
    private String month; // месяц
    private String categoryName; // категория
    private Integer volumeRegularPrice; // факт продаж в штуках по базовой цене
    private Integer volumePromoPrice; // факт продаж по промо цене
    private Float promoPercentage; // % промо


}
