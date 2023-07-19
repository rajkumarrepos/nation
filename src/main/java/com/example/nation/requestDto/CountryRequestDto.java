package com.example.nation.requestDto;

import com.example.nation.entity.CountryEntity;
import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

        private List<StateRequestDto> stateRequestDto;

        public static CountryRequestDto deserialize(CountryEntity countryEntity) {
                return new CountryRequestDto() {{
                        setCountryCode(countryEntity.getCountryCode());
                        setCountryName(countryEntity.getCountryName());
                        setCapital(countryEntity.getCapital());
                        setContinent(countryEntity.getContinent());
                }};
        }
        public  CountryEntity serialize(){
                return new CountryEntity(){{
                        setCountryCode(getCountryCode());
                        setCountryName(getCountryCode());
                        setCapital(getCapital());
                        setContinent(getCapital());
                }};
        }
}
