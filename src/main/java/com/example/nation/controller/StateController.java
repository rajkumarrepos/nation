package com.example.nation.controller;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.StateRequestDto;
import com.example.nation.requestDto.StateUpdateRequestDto;
import com.example.nation.responseDto.StateGetAndUpResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import com.example.nation.responseDto.StateResponseGetDto;
import com.example.nation.service.StateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/state")
public class StateController {
    private final StateService stateService;
    @PostMapping(value="/register")
    public StateResponseDto register(@RequestParam String countryCode, @Valid @RequestBody StateRequestDto stateRequestDto) throws BusinessException {
        return stateService.register(countryCode,stateRequestDto);

    }
    @PutMapping(value = "/update")
    public StateGetAndUpResponseDto update(@RequestParam Integer stateCode, @Valid @RequestBody StateUpdateRequestDto stateUpdateRequestDto) throws BusinessException {
        return  stateService.update(stateCode,stateUpdateRequestDto);
    }
    @GetMapping(value ="getall")
    public List<StateResponseDto> getAll(){
        return stateService.getAll();
    }
}
