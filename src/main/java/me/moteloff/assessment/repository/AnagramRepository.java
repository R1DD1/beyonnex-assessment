package me.moteloff.assessment.repository;

import java.util.List;
import java.util.Set;

public interface AnagramRepository {

    void saveAll(List<String> words);

    Set<String> findAll();

}
