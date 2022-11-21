package com.spring.java.phoneshop.utils;

import org.apache.commons.collections.MapUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PageUtils {
    int DEFAULT_PAGE_SIZE = 10;
    int DEFAULT_PAGE_NUMBER = 1;
    String PAGE_SIZE = "_limit";
    String PAGE_NUMBER = "_page";

    static Pageable getPageable(Map<String, String> params) {

        int pageSize = MapUtils.getIntValue(params, PAGE_SIZE, DEFAULT_PAGE_SIZE);
        int pageNumber = MapUtils.getIntValue(params, PAGE_NUMBER, DEFAULT_PAGE_NUMBER);

        if (pageSize < 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        if (pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        return PageRequest.of(pageNumber - 1, pageSize);
    }
}
