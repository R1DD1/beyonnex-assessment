package me.moteloff.assessment.service;

import me.moteloff.assessment.repository.AnagramRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnagramServiceImplTest {

    @Mock
    AnagramRepository anagramRepository;

    @InjectMocks
    AnagramServiceImpl target;

    @Test
    void shouldReturnTrueWhenWordsAreAnagrams() {
        // Arrange
        var first = "listen";
        var second = "silent";

        // Act
        var result = target.check(first, second);

        // Assert
        assertAll(
                () -> assertTrue(result),
                () -> verify(anagramRepository).saveAll(List.of(first, second)),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldReturnFalseWhenWordsAreNotAnagrams() {
        // Arrange
        var first = "apple";
        var second = "orange";

        // Act
        var result = target.check(first, second);

        // Assert
        assertAll(
                () -> assertFalse(result),
                () -> verify(anagramRepository).saveAll(List.of(first, second)),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldReturnFalseWhenDifferentLength() {
        // Arrange
        var first = "abc";
        var second = "abcd";

        // Act
        var result = target.check(first, second);

        // Assert
        assertAll(
                () -> assertFalse(result),
                () -> verify(anagramRepository).saveAll(List.of(first, second)),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldFindAllAnagramsWhenTheyExist() {
        // Arrange
        var targetWord = "listen";
        var words = Set.of("enlist", "google", "silent", "tinsel", "banana");
        when(anagramRepository.findAll()).thenReturn(words);

        // Act
        var result = target.find(targetWord);

        // Assert
        assertAll(
                () -> assertEquals(List.of("enlist", "silent", "tinsel"), result),
                () -> verify(anagramRepository).findAll(),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldReturnEmptyListWhenNoAnagramsFound() {
        // Arrange
        var targetWord = "hello";
        var words = Set.of("world", "java", "spring");
        when(anagramRepository.findAll()).thenReturn(words);

        // Act
        var result = target.find(targetWord);

        // Assert
        assertAll(
                () -> assertTrue(result.isEmpty()),
                () -> verify(anagramRepository).findAll(),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldReturnEmptyListWhenRepositoryIsEmpty() {
        // Arrange
        when(anagramRepository.findAll()).thenReturn(Set.of());

        // Act
        var result = target.find("any");

        // Assert
        assertAll(
                () -> assertTrue(result.isEmpty()),
                () -> verify(anagramRepository).findAll(),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }

    @Test
    void shouldIgnoreSelfWordWhenFindingAnagrams() {
        // Arrange
        var targetWord = "abc";
        var words = Set.of("abc", "acb");
        when(anagramRepository.findAll()).thenReturn(words);

        // Act
        var result = target.find(targetWord);

        // Assert
        assertAll(
                () -> assertEquals(List.of("acb"), result),
                () -> verify(anagramRepository).findAll(),
                () -> verifyNoMoreInteractions(anagramRepository)
        );
    }
}
