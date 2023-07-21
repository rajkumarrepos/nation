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
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/country")
public class CountryController {

    private final CountryService countryService;
    @Autowired
    private SessionFactory sessionFactory;
    @PostMapping(value="/register")
    @PreAuthorize("hasRole('ADMIN')")
    public CountryResponseDto register(@Valid @RequestBody CountryRequestDto countryRequestDto) throws BusinessException, TechnicalException {
        log.info("-----------------{}------------------------",countryRequestDto);
        return countryService.register(countryRequestDto);
    }

    @GetMapping(value="/getall")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CountryAllRecord> getAll(){
        return countryService.getAll();
    }
    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public CountryGetAndUpResponseDto update(@RequestParam String countryCode,@Valid @RequestBody CountryUpdateRequestDto countryUpdateRequestDto) throws BusinessException, TechnicalException {
        log.info("-----------------{}-------------{}-----------",countryCode,countryUpdateRequestDto);
        return countryService.update(countryCode,countryUpdateRequestDto);
    }
    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam String countryCode) throws BusinessException {
        log.info("-----------------{}------------------------",countryCode);
        String message=countryService.delete(countryCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
