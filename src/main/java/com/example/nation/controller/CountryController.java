package com.example.nation.controller;

import com.example.nation.requestDto.CountryRequestDto;
import com.example.nation.responseDto.CountryResponseDto;
import com.example.nation.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(name = "api/v1/country")
public class CountryController {

    private final CountryService countryService;
    @PostMapping(value="/register")
    public CountryResponseDto register(@Valid @RequestBody CountryRequestDto countryRequestDto){
        return countryService.register(countryRequestDto);


    }


}
