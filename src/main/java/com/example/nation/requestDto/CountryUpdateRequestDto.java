package com.example.nation.requestDto;

import com.example.nation.entity.CountryEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CountryUpdateRequestDto {

        @NotBlank
        private String countryName;
        @NotBlank
        private String capital;
        @NotBlank
        private String continent;

        public  CountryEntity serialize(){
                CountryEntity countryEntity= new  CountryEntity();
                countryEntity.setCountryName(getCountryName());
                countryEntity.setCapital(getCapital());
                countryEntity.setContinent(getContinent());
                return countryEntity;

        }
}
