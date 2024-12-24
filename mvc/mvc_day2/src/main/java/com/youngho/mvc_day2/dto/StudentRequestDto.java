package com.youngho.mvc_day2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record StudentRequestDto(
    @NotBlank
    String id,

    @NotBlank
    String password,

    @NotBlank
    @Length(min = 1)
    String name,

    @Email
    String email,

    @Min(0)
    @Max(100)
    Integer score,

    @NotBlank
    @Length(min = 1, max = 200)
    String evaluation
) {
}
