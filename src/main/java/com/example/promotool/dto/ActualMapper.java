package com.example.promotool.dto;

import com.example.promotool.model.ActualsProjection;

import java.util.List;

public class ActualMapper {

    public static ActualPromoDto toActualPromoDto(ActualsProjection actuals) {
        return ActualPromoDto.builder()
                .chain(actuals.getChain())
                .month(convertMonth(actuals.getDate()))
                .categoryName(actuals.getCategory())
                .volumePromoPrice(actuals.getPromo())
                .volumeRegularPrice(actuals.getRegular())
                .promoPercentage((float) (actuals.getPromo() * 100 / actuals.getMaterials()))
                .build();
    }

    public static String convertMonth(Integer number) {

        List<String> months = List.of("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");

        return months.get(number - 1);
    }

}
