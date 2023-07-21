package com.example.nation.requestDto;

import com.example.nation.entity.DistrictEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DistrictUpdateRequestDto {

    @NotBlank
    private String districtName;

    public  DistrictEntity serialize(){
      DistrictEntity districtEntity= new DistrictEntity();
          districtEntity.setDistrictName(getDistrictName());
     return districtEntity;
    }


}
