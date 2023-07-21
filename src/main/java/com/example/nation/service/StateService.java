package com.example.nation.service;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.StateRequestDto;
import com.example.nation.requestDto.StateUpdateRequestDto;
import com.example.nation.responseDto.StateGetAndUpResponseDto;
import com.example.nation.responseDto.StateResponseDto;

import java.util.List;

public interface StateService {
    StateResponseDto register(String countryCode, StateRequestDto stateRequestDto) throws BusinessException;
    StateGetAndUpResponseDto update(Integer stateCode, StateUpdateRequestDto stateUpdateRequestDto) throws BusinessException;
    List<StateResponseDto> getAll();

    String deleteByCountryId(String id);

    String deleteById(Integer id);
}
