package com.spring.java.phoneshop.mapper;

import com.spring.java.phoneshop.dto.PageDTO;
import com.spring.java.phoneshop.dto.PaginationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface PageMapper {

    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);

    @Mapping(target = "list", expression = "java(page.getContent())")
    @Mapping(target = "pagination", expression = "java(toPaginationDTO(page))")
    PageDTO toDOT(Page<?> page);

    PaginationDTO toPaginationDTO(Page<?> page);
}
