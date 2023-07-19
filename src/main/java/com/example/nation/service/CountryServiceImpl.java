package com.example.nation.service;

import com.example.nation.dao.CountryDao;
import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.repository.CountryRepository;
import com.example.nation.requestDto.CountryRequestDto;
import com.example.nation.responseDto.CountryResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Component
public class CountryServiceImpl {

    private final CountryDao countryDao;
    @Override
    public CountryResponseDto register(CountryRequestDto countryRequestDto){
        CountryResponseDto countryResponseDto=new CountryResponseDto();
        Optional<CountryEntity> countryEntityCheck =countryDao.isCodeExists(countryRequestDto.getCountryCode());
        if(countryEntityCheck.isEmpty() || !countryEntityCheck.get().getCountryCode().equals(countryRequestDto.getCountryCode())){
            CountryEntity countryEntity  =countryRequestDto.serialize();
            try {
                countryDao.save(countryEntity);
                CountryResponseDto.deserialize(countryEntity);
            }catch (Exception e){
            }
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

        }
        else {
            return null;
        }
        return CountryResponseDto.deserialize(c)
        }

    }

