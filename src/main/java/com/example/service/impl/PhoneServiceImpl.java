package com.example.service.impl;

import com.example.dto.PhoneDto;
import com.example.entity.PhoneEntity;
import com.example.exception.NotFoundException;
import com.example.repository.PhoneRepository;
import com.example.service.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PhoneDto> getAll() {
        List<PhoneEntity> list = phoneRepository.findAll();

        return list.stream().map(phoneEntity -> modelMapper.map(phoneEntity, PhoneDto.class))
                                                .collect(Collectors.toList());
    }

    @Override
    public PhoneEntity getById(Long id) {
        PhoneEntity phone = phoneRepository.findById(id).orElseThrow();
        return phone;
    }

    @Override
    public PhoneDto create(PhoneDto phoneDto) {
        PhoneEntity phoneEntity = modelMapper.map(phoneDto, PhoneEntity.class);

        return modelMapper.map(phoneRepository.save(phoneEntity), PhoneDto.class);
    }

    @Override
    public PhoneDto update(Long id, PhoneDto phoneDto) {
        PhoneEntity find = phoneRepository.findById(id).orElseThrow(()
                            -> new NotFoundException(HttpStatus.NOT_FOUND.value(),"ID Khong ton tai:"+ id));

        PhoneEntity phoneEntity = modelMapper.map(phoneDto, PhoneEntity.class);
        phoneEntity.setId(find.getId());

        return modelMapper.map(phoneRepository.save(phoneEntity), PhoneDto.class);
    }


    @Override
    public void delete(Long id) {
        PhoneEntity find = phoneRepository.findById(id).orElseThrow(()
                            -> new NotFoundException(HttpStatus.NOT_FOUND.value(),"ID Khong ton tai:"+ id));

        phoneRepository.deleteById(find.getId());
    }
}
