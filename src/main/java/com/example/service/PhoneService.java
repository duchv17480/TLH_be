package com.example.service;

import com.example.dto.PhoneDto;
import com.example.entity.PhoneEntity;

import java.util.List;

public interface PhoneService {
    List<PhoneDto> getAll();
    PhoneEntity getById(Long id);
    PhoneDto create(PhoneDto phoneDto);
    PhoneDto update(Long id, PhoneDto phoneDto);
    void delete(Long id);
}
