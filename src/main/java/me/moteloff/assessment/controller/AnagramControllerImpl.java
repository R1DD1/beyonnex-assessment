package me.moteloff.assessment.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.moteloff.assessment.dto.check.AnagramCheckDto;
import me.moteloff.assessment.dto.check.AnagramCheckResponseDto;
import me.moteloff.assessment.dto.find.FindAnagramDto;
import me.moteloff.assessment.dto.find.FindAnagramResponseDto;
import me.moteloff.assessment.service.AnagramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
public class AnagramControllerImpl implements AnagramController {

    AnagramService anagramService;

    @Override
    public ResponseEntity<AnagramCheckResponseDto> check(AnagramCheckDto dto) {
        var isAnagram = this.anagramService.check(dto.first(), dto.second());
        return ResponseEntity.ok(new AnagramCheckResponseDto(isAnagram));
    }

    @Override
    public ResponseEntity<FindAnagramResponseDto> findByWord(FindAnagramDto dto) {
        var anagrams = this.anagramService.find(dto.word());
        return ResponseEntity.ok(new FindAnagramResponseDto(anagrams));
    }
}
