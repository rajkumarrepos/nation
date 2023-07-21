package com.example.nation.responseDto;

import com.example.nation.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CountryGetAndUpResponseDto {

    private String  countryCode;

    private String countryName;

    private String capital;

    private String continent;

    public static CountryGetAndUpResponseDto deserialize(CountryEntity countryEntity) {
        CountryGetAndUpResponseDto countryResponseDto= new CountryGetAndUpResponseDto();
            countryResponseDto.setCountryCode(countryEntity.getCountryCode());
            countryResponseDto.setCountryName(countryEntity.getCountryName());
            countryResponseDto.setCapital(countryEntity.getCapital());
            countryResponseDto.setContinent(countryEntity.getContinent());
       return countryResponseDto;

    }
}
