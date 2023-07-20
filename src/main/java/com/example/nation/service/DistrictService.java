package com.example.nation.service;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.DistrictRequestDto;
import com.example.nation.requestDto.DistrictUpdateRequestDto;
import com.example.nation.responseDto.DistrictGetAndUpResponseDto;
import com.example.nation.responseDto.DistrictResponseDto;

import java.util.List;

public interface DistrictService {
    DistrictGetAndUpResponseDto register(Integer stateCode, List<DistrictRequestDto> districtRequestDto) throws BusinessException;
    DistrictResponseDto update(Integer districtCode, DistrictUpdateRequestDto districtUpdateRequestDto) throws BusinessException;
    List<DistrictResponseDto> getAll();
    String delete(Integer districtCode) throws BusinessException;
}
