package me.moteloff.assessment.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.moteloff.assessment.repository.AnagramRepository;
import me.moteloff.assessment.util.AnagramUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class AnagramServiceImpl implements AnagramService {

    AnagramRepository anagramRepository;

    @Override
    public boolean check(String first, String second) {
        this.anagramRepository.saveAll(List.of(first, second));
        return AnagramUtil.checkPair(first, second);
    }

    @Override
    public List<String> find(String target) {
        var result = new ArrayList<String>();

        for (var word : this.anagramRepository.findAll()) {
            if (word.equals(target)) continue;

            if (AnagramUtil.checkPair(target, word)) result.add(word);
        }

        return result;
    }
}
