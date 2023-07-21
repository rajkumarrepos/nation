package com.example.nation.requestDto;


import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StateForCounRequestDto {
    @NotNull
    private Integer stateCode;
    @NotBlank
    private String stateName;
        public  StateEntity serialize(){
            StateEntity stateEntity= new StateEntity();
            stateEntity.setStateCode(getStateCode());
                stateEntity. setStateName(getStateName());
            return stateEntity;
        }


    }

