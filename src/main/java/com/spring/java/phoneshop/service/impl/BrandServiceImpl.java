package com.spring.java.phoneshop.service.impl;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.exception.ResourceNotFoundException;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.repository.BrandRepository;
import com.spring.java.phoneshop.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand save(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public Brand findById(Integer id) throws ApiServiceException {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Brand.class.getName(), id));
    }

    @Override
    public Brand update(Integer id, BrandDTO dto) throws ApiServiceException {
        Brand brand = findById(id);
        brand.setName(dto.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id) throws ApiServiceException {
        Brand brand = findById(id);
        brandRepository.delete(brand);
        log.info("brand with id = %d is deleted.".formatted(id));
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
