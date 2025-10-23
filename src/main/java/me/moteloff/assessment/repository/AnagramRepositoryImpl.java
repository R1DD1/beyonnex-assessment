package me.moteloff.assessment.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Repository
public class AnagramRepositoryImpl implements AnagramRepository {

    Set<String> words = new LinkedHashSet<>();

    @Override
    public void saveAll(List<String> words) {
        this.words.addAll(words);
    }

    @Override
    public Set<String> findAll() {
        return this.words;
    }
}
