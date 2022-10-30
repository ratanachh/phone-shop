package com.spring.java.phoneshop.service;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.model.Model;

import java.util.List;

public interface ModelService {
    Model save(Model entity);
    Model findById(Integer id) throws ApiServiceException;

    Model update(Integer id, ModelDTO dto) throws ApiServiceException;

    void delete(Integer id) throws ApiServiceException;

    List<Model> getModels();
}
