package com.spring.java.phoneshop.dto;

import lombok.Data;

@Data
public class ModelDTO {
    private Integer id;
    private String name;
    private BrandDTO brand;
}
