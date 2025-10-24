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
            summary = "Checks if two words are anagrams",
            description = "(feature 1) Compares two given words to determine if they are anagrams. " +
                          "Both words are also saved to the repository for further use."
    )
    @PostMapping("/check")
    ResponseEntity<AnagramCheckResponseDto> check(@Valid @RequestBody CheckAnagramDto checkAnagramDto);

    @Operation(
            summary = "Finds all anagrams for a given word",
            description = "(feature 2) Searches the repository for all previously saved words " +
                          "and returns those that are anagrams of the provided word."
    )
    @PostMapping("/find")
    ResponseEntity<FindAnagramResponseDto> findByWord(@Valid @RequestBody FindAnagramDto findAnagramDto);

}
