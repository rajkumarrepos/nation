package com.example.nation.responseDto;

import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import com.example.nation.requestDto.CountryRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryResponseDto {

    private String  countryCode;

    private String countryName;

    private String capital;

    private String continent;

    private List<StateGetAndUpResponseDto> stateGetAndUpResponseDtos;

    public static CountryResponseDto deserialize(CountryEntity countryEntity) {
        CountryResponseDto countryResponseDto= new CountryResponseDto();
            countryResponseDto.setCountryCode(countryEntity.getCountryCode());
            countryResponseDto.setCountryName(countryEntity.getCountryName());
            countryResponseDto.setCapital(countryEntity.getCapital());
            countryResponseDto.setContinent(countryEntity.getContinent());
       return countryResponseDto;

    }
}
