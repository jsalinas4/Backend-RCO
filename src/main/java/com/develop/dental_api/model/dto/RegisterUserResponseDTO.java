package com.develop.dental_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserResponseDTO {
    private String message;
    private Long userId;
}
