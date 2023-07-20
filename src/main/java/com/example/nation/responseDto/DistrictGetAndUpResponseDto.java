package com.example.nation.responseDto;


import com.example.nation.entity.DistrictEntity;
import com.example.nation.entity.StateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictGetAndUpResponseDto {
  private StateForDistrictResponseDto stateForDistrictResponseDto;
  private List<DistrictResponseDto> districtResponseDtoList;
}
