package com.example.nation.service;

import com.example.nation.dao.CountryDao;
import com.example.nation.dao.StateDao;
import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.DistrictEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.exception.customException.BaseErrorCodes;
import com.example.nation.exception.customException.BaseException;
import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.StateRequestDto;
import com.example.nation.requestDto.StateUpdateRequestDto;
import com.example.nation.responseDto.CountryResponseDto;
import com.example.nation.responseDto.DistrictResponseDto;
import com.example.nation.responseDto.StateGetAndUpResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StateServiceImpl implements StateService {
    private final StateDao stateDao;
    private final CountryDao countryDao;
    @Override
    public StateResponseDto register(String countryCode, StateRequestDto stateRequestDto) throws BusinessException {
        Optional<StateEntity> stateEntity =stateDao.isStateCodeExists(stateRequestDto.getStateCode());
        if(stateEntity.isEmpty() || !stateEntity.get().getStateCode().equals(stateRequestDto.getStateCode())) {
            StateEntity stateEntityFinal = stateRequestDto.serialize();
            Optional<CountryEntity> countryEntity = countryDao.isCodeExists(countryCode);
            if (countryEntity.isPresent()) {
                stateEntityFinal.setCountryEntity(countryEntity.get());
            } else {
                throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(), BaseErrorCodes.RECORD_NOT_FOUND.message());
            }
            List<DistrictEntity> districtEntityList=new ArrayList<>();
        stateRequestDto.getDistrictRequestDtos().stream().forEach(districtRequestDto -> {
            districtEntityList.add(districtRequestDto.serialize());
        });
        stateEntityFinal.setDistrictEntity(districtEntityList);
        try {
            stateDao.save(stateEntityFinal);
        }catch (Exception e){
            throw new BusinessException(BaseErrorCodes.TECHNICAL_EXCEPTION.name(),BaseErrorCodes.TECHNICAL_EXCEPTION.message());
        }
           return StateResponseDto.deserialize(stateEntityFinal);
        }else{
            throw new BusinessException(BaseErrorCodes.DUPLICATE_RECORD.name(),BaseErrorCodes.DUPLICATE_RECORD.message());
        }
    }
    @Override
    public StateGetAndUpResponseDto update(Integer stateCode, StateUpdateRequestDto stateUpdateRequestDto) throws BusinessException {
        Optional<StateEntity> stateEntity=stateDao.isStateCodeExists(stateCode);
        if(stateEntity.isPresent()){
            stateEntity.get().setStateName(stateUpdateRequestDto.getStateName());
            try{
                stateDao.save(stateEntity.get());
            }catch (Exception e){
                throw new BusinessException(BaseErrorCodes.TECHNICAL_EXCEPTION.name(),BaseErrorCodes.TECHNICAL_EXCEPTION.message());
            }
            return  StateGetAndUpResponseDto.deserialize(stateEntity.get());
        }else{
            throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(),BaseErrorCodes.RECORD_NOT_FOUND.message());
        }

    }
    @Override
    public List<StateResponseDto> getAll(){
        List<StateEntity> stateEntities=stateDao.getAll();
        List<StateResponseDto> stateResponseDtos =new ArrayList<>();
        stateEntities.stream().forEach(obj->{
           StateResponseDto stateResponseDto= StateResponseDto.deserialize(obj);
           stateResponseDtos.add(stateResponseDto);
        });
        return stateResponseDtos;
    }

}
