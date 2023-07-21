package com.example.nation.repository;

import com.example.nation.entity.StateEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StateCriteriaBuilderRepositoryImpl implements StateCriteriaBuilderRepo{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<StateEntity> findTheStateByName(String stateName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StateEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(StateEntity.class);

        Root<StateEntity> project = criteriaBuilderQuery.from(StateEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (stateName != null) {
            predicates.add( criteriaBuilder.like(project.get("stateName"), "%" + stateName + "%"));
        }
        criteriaBuilderQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaBuilderQuery).getResultList();
        }
    }

