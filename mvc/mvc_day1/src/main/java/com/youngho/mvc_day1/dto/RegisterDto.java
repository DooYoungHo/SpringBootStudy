package com.youngho.mvc_day1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterDto(
    @NotBlank
    String id,

    @NotBlank
    String password,

    @NotBlank
    @Length(min = 2, max = 20)
    String name,

    @NotBlank
    @Length(min = 6)
    String email,

    @Min(1)
    @Max(100)
    int score,

    @NotBlank
    String evaluation
) {

}
