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

    private List<StateResponseDto> stateResponseDto;

    public static CountryResponseDto deserialize(CountryEntity countryEntity) {
        return new CountryResponseDto() {{
            setCountryCode(countryEntity.getCountryCode());
            setCountryName(countryEntity.getCountryName());
            setCapital(countryEntity.getCapital());
            setContinent(countryEntity.getContinent());
        }};
    }
}
