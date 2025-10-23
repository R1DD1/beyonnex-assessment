package me.moteloff.assessment.dto.find;

import jakarta.validation.constraints.NotBlank;

public record FindAnagramDto(
        @NotBlank String word
) {
}
