package com.example.nation.service;

import com.example.nation.dao.DistrictDao;
import com.example.nation.dao.StateDao;
import com.example.nation.entity.DistrictEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.exception.customException.BaseErrorCodes;
import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.DistrictRequestDto;
import com.example.nation.requestDto.DistrictUpdateRequestDto;
import com.example.nation.responseDto.DistrictGetAndUpResponseDto;
import com.example.nation.responseDto.DistrictResponseDto;
import com.example.nation.responseDto.StateForDistrictResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Component
public class DistrictServiceImpl implements DistrictService{
    private final StateDao stateDao;
    private final DistrictDao districtDao;
    @Override
    public DistrictGetAndUpResponseDto register(Integer stateCode, List<DistrictRequestDto> districtRequestDto) throws BusinessException {
    Optional<StateEntity> stateEntity =stateDao.isStateCodeExists(stateCode);
    List<DistrictResponseDto> districtResponseDtos=new ArrayList<>();
    if(stateEntity.isPresent()){
        districtRequestDto.stream().forEach(district->{
           if( !(districtDao.isExistsCode(district.getDistrictCode()).isPresent())) {
               DistrictEntity districtEntity = district.serialize();
               districtEntity.setStateEntity(stateEntity.get());
               districtDao.save(districtEntity);
               log.debug("-----------------{}------------------------",districtEntity);
               districtResponseDtos.add(DistrictResponseDto.deserialize(districtEntity));
           }else{
               try {
                   throw new BusinessException(BaseErrorCodes.DUPLICATE_RECORD.name(),BaseErrorCodes.DUPLICATE_RECORD.message());
               } catch (BusinessException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        DistrictGetAndUpResponseDto districtGetAndUpResponseDto = new DistrictGetAndUpResponseDto();
        districtGetAndUpResponseDto.setDistrictResponseDtoList(districtResponseDtos);
        districtGetAndUpResponseDto.setStateForDistrictResponseDto(StateForDistrictResponseDto.deserialize(stateEntity.get()));
        return districtGetAndUpResponseDto;
    }else{
        throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(),BaseErrorCodes.RECORD_NOT_FOUND.message());
    }

    }
    @Override
    public DistrictResponseDto update(Integer districtCode, DistrictUpdateRequestDto districtUpdateRequestDto) throws BusinessException {
        Optional<DistrictEntity> districtEntity=districtDao.isExistsCode(districtCode);
        if(districtEntity.isPresent()){
            districtEntity.get().setDistrictName(districtUpdateRequestDto.getDistrictName());
            districtDao.save(districtEntity.get());
          return  DistrictResponseDto.deserialize(districtEntity.get());
        }else{
            throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(),BaseErrorCodes.RECORD_NOT_FOUND.message());
        }

  }
  @Override
    public List<DistrictResponseDto> getAll(){
        List<DistrictEntity> districtEntities=districtDao.getAll();
        List<DistrictResponseDto> districtResponseDtos=new ArrayList<>();
        districtEntities.stream().forEach(obj->{
            DistrictResponseDto districtResponseDto=DistrictResponseDto.deserialize(obj);
            districtResponseDtos.add(districtResponseDto);
        });
        return districtResponseDtos;

    }
    @Override
    @Transactional
    public String delete(Integer districtCode) throws BusinessException {
       Optional<DistrictEntity> districtEntity = districtDao.isExistsCode(districtCode);
       if(districtEntity.isPresent()){
           districtDao.delete(districtEntity.get().getId());
           return "deleted successfully";
       }else{
           throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(),BaseErrorCodes.RECORD_NOT_FOUND.message());
       }
    }
}