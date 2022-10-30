package com.spring.java.phoneshop.mapper;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    Model toModel(ModelDTO dto);

    ModelDTO toDTO(Model entity);
}
