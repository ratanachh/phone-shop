package com.spring.java.phoneshop.controller;

import com.spring.java.phoneshop.dto.BrandDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.mapper.BrandMapper;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.toEntity(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody BrandDTO dto) {
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
                .map(BrandMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listBrand);
    }
}
