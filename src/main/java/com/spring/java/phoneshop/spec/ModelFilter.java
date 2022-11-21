package com.spring.java.phoneshop.spec;

import lombok.Data;

@Data
public class ModelFilter {
    private Integer modelId;
    private Integer brandId;
    private String modelName;
    private String brandName;
}
