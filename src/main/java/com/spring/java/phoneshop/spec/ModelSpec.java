package com.spring.java.phoneshop.spec;

import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ModelSpec implements Specification<Model> {

    private final ModelFilter modelFilter;
    @Override
    public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Join<Model, Brand> brand = model.join("brand");
        List<Predicate> predicateList = new ArrayList<>();

        if (modelFilter.getModelId() != null) {
            predicateList.add(model.in(model.get("id"), modelFilter.getModelId()));
        }

        if (modelFilter.getBrandId() != null) {
            predicateList.add(brand.in(brand.get("id"), modelFilter.getBrandId()));
        }

        if (modelFilter.getModelName() != null) {
            predicateList.add(cb.like(model.get("name"), "%" + modelFilter.getModelName() + "%"));
        }

        if (modelFilter.getBrandName() != null) {
            predicateList.add(cb.like(brand.get("name"), "%" + modelFilter.getBrandName() + "%"));
        }

        return cb.and(predicateList.toArray(new Predicate[0]));
    }
}
