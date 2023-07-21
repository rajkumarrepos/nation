package com.example.nation.service;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.StateRequestDto;
import com.example.nation.requestDto.StateUpdateRequestDto;
import com.example.nation.responseDto.StateGetAndUpResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StateService {
    StateResponseDto register(String countryCode, StateRequestDto stateRequestDto) throws BusinessException;
    StateGetAndUpResponseDto update(Integer stateCode, StateUpdateRequestDto stateUpdateRequestDto) throws BusinessException;
    List<StateResponseDto> getAll(Pageable pageable);

    String deleteByCountryId(String id);

    String delete(Integer stateCode) throws BusinessException;
}
