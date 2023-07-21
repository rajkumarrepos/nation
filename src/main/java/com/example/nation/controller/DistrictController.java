package com.example.nation.controller;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.DistrictRequestDto;
import com.example.nation.requestDto.DistrictUpdateRequestDto;
import com.example.nation.responseDto.DistrictGetAndUpResponseDto;
import com.example.nation.responseDto.DistrictResponseDto;
import com.example.nation.service.DistrictService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
    private final DistrictService districtService;
    @PostMapping(value = "/register")
    @PreAuthorize("hasRole('MANAGER')")
    public DistrictGetAndUpResponseDto register(@RequestParam Integer stateCode, @Valid @RequestBody List<DistrictRequestDto> districtRequestDto) throws BusinessException {
        log.info("-----------------{}-------------{}-----------",stateCode,districtRequestDto.size());
     return districtService.register(stateCode,districtRequestDto);
    }
    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('MANAGER')")
    public DistrictResponseDto update(@RequestParam Integer districtCode ,@Valid @RequestBody DistrictUpdateRequestDto districtUpdateRequestDto) throws BusinessException {
        log.info("-----------------{}-------------{}-----------",districtCode,districtUpdateRequestDto);
        return districtService.update(districtCode,districtUpdateRequestDto);
    }
    @GetMapping(value = "/getall")
    @PreAuthorize("hasRole('MANAGER')")
    public List<DistrictResponseDto> getAll(){
        return districtService.getAll();
    }
    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<?> delete(@RequestParam Integer districtCode) throws BusinessException {
        log.info("-----------------{}------------------------",districtCode);
        String message=districtService.delete(districtCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
