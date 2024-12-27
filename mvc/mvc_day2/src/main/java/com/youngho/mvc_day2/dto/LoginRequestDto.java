package com.youngho.mvc_day2.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
    @NotBlank
    String id,

    @NotBlank
    String password
) {

}
