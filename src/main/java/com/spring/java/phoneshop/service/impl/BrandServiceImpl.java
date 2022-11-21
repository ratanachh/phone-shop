package com.spring.java.phoneshop.service.impl;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.exception.ResourceNotFoundException;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.repository.BrandRepository;
import com.spring.java.phoneshop.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public Brand save(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Brand.class.getName(), id));
    }

    @Override
    public Brand update(Integer id, BrandDTO dto) {
        Brand brand = findById(id);
        brand.setName(dto.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        Brand brand = findById(id);
        brandRepository.delete(brand);
        log.info(String.format("brand with id = %d is deleted.", id));
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
