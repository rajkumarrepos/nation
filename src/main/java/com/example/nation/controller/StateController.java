package com.example.nation.controller;

import com.example.nation.exception.customException.BusinessException;
import com.example.nation.requestDto.StateRequestDto;
import com.example.nation.requestDto.StateUpdateRequestDto;
import com.example.nation.responseDto.StateGetAndUpResponseDto;
import com.example.nation.responseDto.StateResponseDto;
import com.example.nation.responseDto.StateResponseGetDto;
import com.example.nation.service.GlobalSearchService;
import com.example.nation.service.GlobalSearchServiceImpl;
import com.example.nation.service.StateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/state")
public class StateController {
    private final StateService stateService;
    private final GlobalSearchService globalSearchService;
    @Autowired
    private SessionFactory sessionFactory;
    @PostMapping(value="/register")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public StateResponseDto register(@RequestParam String countryCode, @Valid @RequestBody StateRequestDto stateRequestDto) throws BusinessException {
        log.info("-----------------{}-------------{}-----------",countryCode,stateRequestDto);
        return stateService.register(countryCode,stateRequestDto);

    }
    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public StateGetAndUpResponseDto update(@RequestParam Integer stateCode, @Valid @RequestBody StateUpdateRequestDto stateUpdateRequestDto) throws BusinessException {
        log.info("-----------------{}-------------{}-----------",stateCode,stateUpdateRequestDto);
        return  stateService.update(stateCode,stateUpdateRequestDto);
    }
    @GetMapping(value ="getall")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public List<StateResponseDto> getAll(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size, @RequestParam(value = "column") String column){
        sessionFactory.getCache().evictAllRegions();
        log.info("-----------------{}-------------{}------{}-----",page,size,column);
        Pageable pageable = PageRequest.of(page, size, Sort.by(column));
        return stateService.getAll(pageable);
    }

    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public ResponseEntity<String> delete(@RequestParam Integer stateCode) throws BusinessException {
        log.info("-----------------{}------------------------",stateCode);
        String message=stateService.delete(stateCode);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping(value="searchState")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public List<StateResponseDto> searchTheState(@RequestParam(value = "searchState") String searchState ){
        log.info("-----------------{}------------------------",searchState);
        return globalSearchService.globalSearchService(searchState);
    }
}
