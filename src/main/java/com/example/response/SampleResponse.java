package com.example.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleResponse {
    private Boolean success;
    private String message;
    private Object data;

}