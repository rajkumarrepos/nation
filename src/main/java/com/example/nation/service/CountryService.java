package com.example.nation.service;

import com.example.nation.entity.CountryEntity;
import com.example.nation.exception.customException.BusinessException;
import com.example.nation.exception.customException.TechnicalException;
import com.example.nation.requestDto.CountryRequestDto;
import com.example.nation.requestDto.CountryUpdateRequestDto;
import com.example.nation.responseDto.CountryAllRecord;
import com.example.nation.responseDto.CountryGetAndUpResponseDto;
import com.example.nation.responseDto.CountryResponseDto;

import java.util.List;

public interface CountryService {
    CountryResponseDto register(CountryRequestDto countryRequestDto) throws BusinessException, TechnicalException;
    List<CountryAllRecord>  getAll();
    CountryGetAndUpResponseDto update(String countryCode, CountryUpdateRequestDto countryUpdateRequestDto) throws BusinessException, TechnicalException;
    String delete(String countryCode) throws BusinessException;
}
