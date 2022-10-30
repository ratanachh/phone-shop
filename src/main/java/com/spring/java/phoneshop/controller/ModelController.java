package com.spring.java.phoneshop.controller;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.mapper.ModelMapper;
import com.spring.java.phoneshop.model.Model;
import com.spring.java.phoneshop.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDTO dto) {
        Model model = ModelMapper.INSTANCE.toModel(dto);
        model = modelService.save(model);
        return ResponseEntity.ok(model);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return ResponseEntity.ok(modelService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ModelDTO dto) {
        return ResponseEntity.ok(modelService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById (@PathVariable("id") Integer id) {
        modelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<ModelDTO> listModel = modelService.getModels()
                .stream()
                .map(ModelMapper.INSTANCE::toDTO)
                .toList();
        return ResponseEntity.ok(listModel);
    }
}
