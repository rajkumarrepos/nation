package com.example.nation.responseDto;


import com.example.nation.entity.DistrictEntity;
import com.example.nation.entity.StateEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DistrictGetAndUpResponseDto {
  private StateForDistrictResponseDto stateForDistrictResponseDto;
  private List<DistrictResponseDto> districtResponseDtoList;
}
