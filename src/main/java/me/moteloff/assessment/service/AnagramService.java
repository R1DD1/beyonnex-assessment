package me.moteloff.assessment.service;

import java.util.List;

public interface AnagramService {

    boolean check(String first, String second);

    List<String> find(String target);
}
