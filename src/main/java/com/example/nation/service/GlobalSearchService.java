package com.example.nation.service;

import com.example.nation.responseDto.StateResponseDto;


import java.util.List;

public interface GlobalSearchService {
   List<StateResponseDto> globalSearchService( String stateName);
}
