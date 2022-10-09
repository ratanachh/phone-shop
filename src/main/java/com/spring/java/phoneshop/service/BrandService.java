package com.spring.java.phoneshop.service;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.model.Brand;

import java.util.List;

public interface BrandService {
    Brand save(Brand entity);
    Brand findById(Integer id);

    Brand update(Integer id, BrandDTO dto);

    void delete(Integer id);

    List<Brand> getBrands();
}
