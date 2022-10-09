package com.spring.java.phoneshop.controller;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.mapper.EntityMapper;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = EntityMapper.toBrand(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);
    }


    @GetMapping("{id}")
    public ResponseEntity<Brand> find(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") Integer id, @RequestBody BrandDTO dto) {
        return ResponseEntity.ok(brandService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById (@PathVariable("id") Integer id) {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<BrandDTO> listBrand = brandService.getBrands()
                .stream()
                .map(EntityMapper::toBrandDTO)
                .toList();
        return ResponseEntity.ok(listBrand);
    }
}
