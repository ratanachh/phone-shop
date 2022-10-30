package com.spring.java.phoneshop.mapper;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toEntity(BrandDTO dto);

    BrandDTO toDTO(Brand brand);
}
