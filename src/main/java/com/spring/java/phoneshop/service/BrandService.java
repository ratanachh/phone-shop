package com.spring.java.phoneshop.service;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Brand save(Brand entity);
    Brand findById(Integer id) throws ApiServiceException;

    Brand update(Integer id, BrandDTO dto) throws ApiServiceException;

    void delete(Integer id) throws ApiServiceException;

    List<Brand> getBrands();
}
