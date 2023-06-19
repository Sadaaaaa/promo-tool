package com.example.promotool.service;

import com.example.promotool.dao.ActualsRepository;
import com.example.promotool.dto.ActualByDaysDto;
import com.example.promotool.dto.ActualMapper;
import com.example.promotool.dto.ActualPromoDto;
import com.example.promotool.dto.RequestDto;
import com.example.promotool.model.Actuals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    private final ActualsRepository actualsRepository;

    @Autowired
    public AnalysisServiceImpl(ActualsRepository actualsRepository) {
        this.actualsRepository = actualsRepository;
    }

    @Override
    public List<ActualPromoDto> getPromo() {
        calculatePromoAndUpdateDb();
        return actualsRepository.getAnalyzeTable().stream().map(ActualMapper::toActualPromoDto).collect(Collectors.toList());
    }

    @Override
    public List<ActualByDaysDto> getFactsByDay(RequestDto requestDto) {
        List<Actuals> actuals = actualsRepository.findAllByChainInAndMaterialIdIn(requestDto.getChains(), requestDto.getMaterialIds());
        return actuals.stream().map(ActualMapper::toActualByDaysDto).collect(Collectors.toList());
    }


    public void calculatePromoAndUpdateDb() {
        List<Actuals> actualsPromo = actualsRepository.getPromo();
        actualsPromo.forEach(actuals -> actuals.setPromo("promo"));
        actualsRepository.saveAll(actualsPromo);

        List<Actuals> getRegular = actualsRepository.getRegular();
        getRegular.forEach(actuals -> actuals.setPromo("regular"));
        actualsRepository.saveAll(getRegular);
    }
}
