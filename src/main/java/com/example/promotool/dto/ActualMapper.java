package com.example.promotool.dto;

import com.example.promotool.model.Actuals;
import com.example.promotool.model.ActualsProjection;
import com.example.promotool.model.Customers;

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

    public static ActualByDaysDto toActualByDaysDto(Actuals actuals) {
        return ActualByDaysDto.builder()
                .date(actuals.getDate())
                .materialId(actuals.getMaterialId())
                .shipToCode(actuals.getShipToCode())
                .chain(actuals.getChain())
                .volumeUnits(actuals.getVolumeUnits())
                .actualSalesValue(actuals.getActualSalesValue())
                .promo(actuals.getPromo())
                .customer(actuals.getCustomer())
                .products(actuals.getProducts())
                .build();
    }

}
