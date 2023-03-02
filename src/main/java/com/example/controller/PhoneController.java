package com.example.controller;

import com.example.dto.PhoneDto;
import com.example.exception.DefaultResponse;
import com.example.response.SampleResponse;
import com.example.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        SampleResponse sampleResponse = SampleResponse.builder()
                .success(true)
                .message("Successfully")
                .data(phoneService.getAll())
                .build();
        return ResponseEntity.ok(sampleResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        SampleResponse sampleResponse = SampleResponse.builder()
                .success(true)
                .message("Successfully")
                .data(phoneService.getById(id))
                .build();
        return ResponseEntity.ok(sampleResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PhoneDto phoneDto){
        SampleResponse sampleResponse = SampleResponse.builder()
                .success(true)
                .message("Successfully")
                .data(phoneService.create(phoneDto))
                .build();
        return ResponseEntity.ok(sampleResponse);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody PhoneDto phoneDto){
        SampleResponse sampleResponse = SampleResponse.builder()
                .success(true)
                .message("Successfully")
                .data(phoneService.update(id, phoneDto))
                .build();
        return ResponseEntity.ok(sampleResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        phoneService.delete(id);
        return ResponseEntity.ok(DefaultResponse.success("Successfully "+ id));
    }
}
