package com.spring.java.phoneshop.service;

import com.spring.java.phoneshop.exception.ResourceNotFoundException;
import com.spring.java.phoneshop.model.Brand;
import com.spring.java.phoneshop.repository.BrandRepository;
import com.spring.java.phoneshop.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    private BrandService brandService;

    @BeforeEach
    public void setup() {
        brandService = new BrandServiceImpl(brandRepository);
    }

    @Test
    public void testSaveModel()
    {
        // given
        Brand brand = new Brand();
        brand.setName("Apple");

        // when
        when(brandRepository.save(any(Brand.class))).thenAnswer(invocationOnMock -> {
            Brand brandEntity = invocationOnMock.getArgument(0);
            brandEntity.setId(1);
            return brandEntity;
        });

        // then
        brandService.save(brand);

        verify(brandRepository, times(1)).save(brand);
    }

    @Test
    public void testGetModelById() {
        // given
        Brand brand = new Brand(1, "Apple");
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));

        // when
        Brand brandReturn = brandService.findById(1);

        // then
        assertNotNull(brand);
        assertEquals(1,  brandReturn.getId());
        assertEquals("Apple",  brandReturn.getName());
    }
    
    @Test
    public void testGetByIdThrowException() {
    	
    	// given
    	
    	// when
    	when(brandRepository.findById(2)).thenReturn(Optional.empty());
    	
    	// then
    	assertThatThrownBy(() -> brandService.findById(2))
    		.isInstanceOf(ResourceNotFoundException.class)
    		.hasMessageStartingWith(Brand.class.getName() + " can't found with id");
    }

}
