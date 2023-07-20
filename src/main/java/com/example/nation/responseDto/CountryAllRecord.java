package com.example.nation.responseDto;

import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
public class CountryAllRecord {

    private String countryCode;
    private String countryName;
    private String capital;
    private String continent;
    private List<StateResponseGetDto> stateResponseGetDtos;

    public static CountryAllRecord deserialize(CountryEntity countryEntity) {
        CountryAllRecord countryAllRecord = new CountryAllRecord();
        countryAllRecord.setCountryCode(countryEntity.getCountryCode());
        countryAllRecord.setCountryName(countryEntity.getCountryName());
        countryAllRecord.setCapital(countryEntity.getCapital());
        countryAllRecord.setContinent(countryEntity.getContinent());
        return countryAllRecord;
    }
}
