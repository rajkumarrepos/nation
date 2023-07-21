package com.example.nation.repository;

import com.example.nation.entity.StateEntity;


import java.util.List;

public interface StateCriteriaBuilderRepo {
    List<StateEntity> findTheStateByName(String stateName);
}
