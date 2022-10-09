package com.spring.java.phoneshop.mapper;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.model.Brand;

public class EntityMapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setName(dto.getName());
        return brand;
    }
    public static BrandDTO toBrandDTO(Brand entity) {
        BrandDTO dto = new BrandDTO();
        dto.setName(entity.getName());
        return dto;
    }

}
