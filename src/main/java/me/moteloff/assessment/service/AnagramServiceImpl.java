package me.moteloff.assessment.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.moteloff.assessment.repository.AnagramRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class AnagramServiceImpl implements AnagramService {

    AnagramRepository anagramRepository;

    @Override
    public boolean check(String first, String second) {
        this.anagramRepository.saveAll(List.of(first, second));
        return this.checkPair(first, second);
    }

    @Override
    public List<String> find(String target) {
        var result = new ArrayList<String>();

        for (var word : this.anagramRepository.findAll()) {
            if (word.equals(target)) continue;

            if (this.checkPair(target, word)) result.add(word);
        }

        return result;
    }

    private boolean checkPair(String first, String second) {
        if (first.length() != second.length()) return false;

        var firstChars = first.toCharArray();
        var secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        return Arrays.equals(firstChars, secondChars);
    }
}
