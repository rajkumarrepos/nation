package com.example.nation.requestDto;


import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateRequestDto {
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

