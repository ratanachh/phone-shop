package com.spring.java.phoneshop.service.impl;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.repository.BrandRepository;
import com.spring.java.phoneshop.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

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
    public Brand findById(Integer id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            return brand.get();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Can't find brand id=%d", id));
        }
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
        log.info("brand with id = %d is deleted.".formatted(id));
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
