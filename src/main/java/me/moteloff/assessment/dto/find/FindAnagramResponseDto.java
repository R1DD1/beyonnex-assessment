package me.moteloff.assessment.dto.find;

import java.util.List;

public record FindAnagramResponseDto(
        List<String> anagrams
) {
}
