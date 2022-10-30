package com.spring.java.phoneshop.service.impl;

import com.spring.java.phoneshop.dto.ModelDTO;
import com.spring.java.phoneshop.exception.ApiServiceException;
import com.spring.java.phoneshop.exception.ResourceNotFoundException;
import com.spring.java.phoneshop.model.Model;
import com.spring.java.phoneshop.repository.ModelRepository;
import com.spring.java.phoneshop.service.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public Model save(Model entity) {
        return modelRepository.save(entity);
    }

    @Override
    public Model findById(Integer id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Model.class.getName(), id));
    }

    @Override
    public Model update(Integer id, ModelDTO dto) {
        Model model = findById(id);
        return modelRepository.save(model);
    }

    @Override
    public void delete(Integer id) {
        Model model = findById(id);
        modelRepository.delete(model);
        log.info("brand with id = %d is deleted.".formatted(id));
    }

    @Override
    public List<Model> getModels() {
        return modelRepository.findAll();
    }
}
