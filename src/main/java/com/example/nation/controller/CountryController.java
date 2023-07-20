package com.example.nation.controller;

import com.example.nation.entity.CountryEntity;
import com.example.nation.exception.customException.BusinessException;
import com.example.nation.exception.customException.TechnicalException;
import com.example.nation.requestDto.CountryRequestDto;
import com.example.nation.requestDto.CountryUpdateRequestDto;
import com.example.nation.responseDto.CountryAllRecord;
import com.example.nation.responseDto.CountryGetAndUpResponseDto;
import com.example.nation.responseDto.CountryResponseDto;
import com.example.nation.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(name = "api/v1/country")
public class CountryController {

    private final CountryService countryService;
    @PostMapping(value="/register")
    public CountryResponseDto register(@Valid @RequestBody CountryRequestDto countryRequestDto) throws BusinessException, TechnicalException {
        return countryService.register(countryRequestDto);
    }

    @GetMapping(value="/getall")
    public List<CountryGetAndUpResponseDto> getAll(){
        return countryService.getAll();
    }
    @PutMapping(value = "/update")
    public CountryGetAndUpResponseDto update(@RequestParam String countryCode,@Valid @RequestBody CountryUpdateRequestDto countryUpdateRequestDto) throws BusinessException, TechnicalException {
        return countryService.update(countryCode,countryUpdateRequestDto);
    }
}
