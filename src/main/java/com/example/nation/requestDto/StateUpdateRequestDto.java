package com.example.nation.requestDto;


import com.example.nation.entity.StateEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateUpdateRequestDto {

    @NotBlank
    private String stateName;

        public  StateEntity serialize(){
            StateEntity stateEntity= new StateEntity();
                stateEntity. setStateName(getStateName());
            return stateEntity;
        }


    }

