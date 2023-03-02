package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneDto {
    private Long id;

    private String name;

    private String color;

    private String brand;

    private String price;
}
