package com.example.nation.controller;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.DistrictRequestDto;
import com.example.nation.requestDto.DistrictUpdateRequestDto;
import com.example.nation.responseDto.DistrictGetAndUpResponseDto;
import com.example.nation.responseDto.DistrictResponseDto;
import com.example.nation.service.DistrictService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
    private final DistrictService districtService;
    @PostMapping(value = "/register")
    public DistrictGetAndUpResponseDto register(@RequestParam Integer stateCode, @Valid @RequestBody List<DistrictRequestDto> districtRequestDto) throws BusinessException {
     return districtService.register(stateCode,districtRequestDto);
    }
    @PutMapping(value = "/update")
    public DistrictResponseDto update(@RequestParam Integer districtCode ,@Valid @RequestBody DistrictUpdateRequestDto districtUpdateRequestDto) throws BusinessException {
        return districtService.update(districtCode,districtUpdateRequestDto);
    }
    @GetMapping(value = "/getall")
    public List<DistrictResponseDto> getAll(){
        return districtService.getAll();
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestParam Integer districtCode) throws BusinessException {
        String message=districtService.delete(districtCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
