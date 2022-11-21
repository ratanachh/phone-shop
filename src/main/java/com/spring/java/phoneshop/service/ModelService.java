package com.spring.java.phoneshop.service;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.model.Model;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ModelService {
    Model save(Model entity);
    Model findById(Integer id);

    Model update(Integer id, ModelDTO dto);

    void delete(Integer id);

    Page<Model> getModels(Map<String, String> params);
}
