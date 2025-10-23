package me.moteloff.assessment.dto.check;

import jakarta.validation.constraints.NotBlank;

public record CheckAnagramDto(
        @NotBlank String first,
        @NotBlank String second
) {
}
