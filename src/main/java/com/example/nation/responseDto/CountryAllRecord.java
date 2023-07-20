package com.example.nation.responseDto;

import com.example.nation.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CountryAllRecord {
    private CountryResponseDto countryResponseDto;
    private List<StateResponseDto> stateResponseDtoList;
    private List<DistrictResponseDto> districtResponseDtoList;

//    public static CountryAllRecord deserialize(CountryEntity countryEntity){
//        CountryAllRecord countryAllRecord = new CountryAllRecord();
//        countryAllRecord.setCountryResponseDto(countryEntity.);
//    }
}
