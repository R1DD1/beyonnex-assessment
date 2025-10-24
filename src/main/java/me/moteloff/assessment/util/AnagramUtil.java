package me.moteloff.assessment.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class AnagramUtil {

    public boolean checkPair(String first, String second) {
        if (first.length() != second.length()) return false;

        var firstChars = first.toCharArray();
        var secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        return Arrays.equals(firstChars, secondChars);
    }
}
