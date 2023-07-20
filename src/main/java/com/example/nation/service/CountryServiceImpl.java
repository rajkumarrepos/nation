package com.example.nation.service;

import com.example.nation.dao.CountryDao;
import com.example.nation.dao.StateDao;
import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.exception.customException.BaseErrorCodes;
import com.example.nation.exception.customException.BusinessException;


import com.example.nation.exception.customException.TechnicalException;
import com.example.nation.requestDto.CountryRequestDto;
import com.example.nation.requestDto.CountryUpdateRequestDto;
import com.example.nation.responseDto.CountryAllRecord;
import com.example.nation.responseDto.CountryGetAndUpResponseDto;
import com.example.nation.responseDto.CountryResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Component
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final StateDao stateDao;

    @Override
    public CountryResponseDto register(CountryRequestDto countryRequestDto) throws BusinessException, TechnicalException {
        Optional<CountryEntity> countryEntityCheck =countryDao.isCodeExists(countryRequestDto.getCountryCode());
        if(countryEntityCheck.isEmpty() || !countryEntityCheck.get().getCountryCode().equals(countryRequestDto.getCountryCode())){
            CountryEntity countryEntity  =countryRequestDto.serialize();
            try {
                log.info("-------------"+(countryEntity));
                countryDao.save(countryEntity);

            }catch (Exception e){
                throw new TechnicalException(BaseErrorCodes.TECHNICAL_EXCEPTION.message());
            }
            CountryResponseDto.deserialize(countryEntity);
            List<StateResponseDto> stateResponseDtoList = new ArrayList<>();
           countryRequestDto.getStateRequestDto().stream().forEach(state->{
               StateEntity stateEntity =state.serialize();
               try{
                   stateDao.save(stateEntity);
               }catch (Exception e){}
               StateResponseDto stateResponseDto=StateResponseDto.deserialize(stateEntity);
               stateResponseDtoList.add(stateResponseDto);


           });
            CountryResponseDto countryResponseDtoFinal=CountryResponseDto.deserialize(countryEntity);
            countryResponseDtoFinal.setStateResponseDto(stateResponseDtoList);
            return countryResponseDtoFinal;

        }
        else {
            throw new BusinessException(BaseErrorCodes.DUPLICATE_RECORD.message());

        }

        }
        @Override
        public List<CountryGetAndUpResponseDto> getAll(){
        List<CountryEntity> countryEntity=countryDao.getAll();
        List<CountryGetAndUpResponseDto> countryGetAndUpResponseDtoList = new ArrayList<>();
        countryEntity.stream().forEach(country ->{
            CountryGetAndUpResponseDto countryGetAndUpResponseDto=CountryGetAndUpResponseDto.deserialize(country);
            countryGetAndUpResponseDtoList.add(countryGetAndUpResponseDto);
        });
        return countryGetAndUpResponseDtoList;

        }
        @Override
        public CountryGetAndUpResponseDto update(String countryCode, CountryUpdateRequestDto countryUpdateRequestDto) throws BusinessException, TechnicalException {
        Optional<CountryEntity> countryEntity=countryDao.isCodeExists(countryCode);
        if(countryEntity.isPresent()){
                        countryEntity.get().setCountryName(countryUpdateRequestDto.getCountryName());
                        countryEntity.get().setCapital(countryUpdateRequestDto.getCapital());
                        countryEntity.get().setContinent(countryUpdateRequestDto.getContinent());
            try {
                countryDao.save(countryEntity.get());
            }catch (Exception e) {
                throw new TechnicalException(BaseErrorCodes.TECHNICAL_EXCEPTION.name(),BaseErrorCodes.TECHNICAL_EXCEPTION.message());
            }

            return  CountryGetAndUpResponseDto.deserialize(countryEntity.get());

        }else{
            throw new BusinessException(BaseErrorCodes.RECORD_NOT_FOUND.name(),BaseErrorCodes.RECORD_NOT_FOUND.message());
        }

        }

    }

