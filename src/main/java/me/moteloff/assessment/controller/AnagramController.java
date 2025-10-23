package me.moteloff.assessment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import me.moteloff.assessment.dto.find.FindAnagramDto;
import me.moteloff.assessment.dto.find.FindAnagramResponseDto;
import me.moteloff.assessment.dto.check.CheckAnagramDto;
import me.moteloff.assessment.dto.check.AnagramCheckResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Anagrams", description = "Anagram API")
@RequestMapping("/api/v1/anagram")
public interface AnagramController {

    @Operation(
            summary = "Checks if anagrams",
            description = "(feature 1)"
    )
    @PostMapping("/check")
    ResponseEntity<AnagramCheckResponseDto> check(@Valid @RequestBody CheckAnagramDto checkAnagramDto);

    @Operation(
            summary = "Find anagrams",
            description = "(feature 2)"
    )
    @PostMapping("/find")
    ResponseEntity<FindAnagramResponseDto> findByWord(@Valid @RequestBody FindAnagramDto findAnagramDto);

}
