package com.spring.java.phoneshop.service.impl;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.exception.ResourceNotFoundException;
import com.spring.java.phoneshop.model.Model;
import com.spring.java.phoneshop.repository.ModelRepository;
import com.spring.java.phoneshop.service.ModelService;
import com.spring.java.phoneshop.spec.ModelFilter;
import com.spring.java.phoneshop.spec.ModelSpec;
import com.spring.java.phoneshop.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public Model save(Model entity) {
        return modelRepository.save(entity);
    }

    @Override
    public Model findById(Integer id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Model.class.getName(), id));
    }

    @Override
    public Model update(Integer id, ModelDTO dto) {
        Model model = findById(id);
        return modelRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        Model model = findById(id);
        modelRepository.delete(model);
        log.info(String.format("brand with id = %d is deleted.", id));
    }

    @Override
    public Page<Model> getModels(Map<String, String> params) {
        ModelFilter modelFilter = new ModelFilter();

        if (params.containsKey("modelId")) {
            modelFilter.setModelId(MapUtils.getInteger(params, "modelId"));
        }

        if (params.containsKey("brandId")) {
            modelFilter.setBrandId(MapUtils.getInteger(params, "brandId"));
        }

        if (params.containsKey("modelName")) {
            modelFilter.setModelName(MapUtils.getString(params, "modelName"));
        }

        if (params.containsKey("brandName")) {
            modelFilter.setBrandName(MapUtils.getString(params, "brandName"));
        }

        ModelSpec modelSpec = new ModelSpec(modelFilter);
        Pageable pageable = PageUtils.getPageable(params);

        return modelRepository.findAll(modelSpec, pageable);
    }
}
