package com.example.nation.requestDto;

import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequestDto {
        @NotNull
        private String  countryCode;
        @NotBlank
        private String countryName;
        @NotBlank
        private String capital;
        @NotBlank
        private String continent;

        private List<StateForCounRequestDto> stateForCounRequestDtos;

        public  CountryEntity serialize(){
                CountryEntity countryEntity= new  CountryEntity();
                        countryEntity.setCountryCode(getCountryCode());
                countryEntity.setCountryName(getCountryName());
                countryEntity.setCapital(getCapital());
                countryEntity.setContinent(getContinent());
                return countryEntity;

        }
}
