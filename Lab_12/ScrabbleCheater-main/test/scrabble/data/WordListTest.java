package scrabble.data;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordListTest {

    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"just two", "ba", new String[]{"ab", "ba"},
                        new String[]{"ab", "ba"},
                        new String[]{"ab", "ba"}},
                {"just two with three characters", "abc",
                        new String[]{"abc", "cba"},
                        new String[]{"abc", "cba"},
                        new String[]{"abc", "cba"}},
                {
                        "the correct number from the word list",
                        "abc",
                        new String[]{"abc", "cba"},
                        new String[]{"ab", "bc", "abc", "cba"},
                        new String[]{"ab", "bc", "ad", "abc", "cba", "asd",
                                "asdfjkafs", "aa"}},
                {"the correct number from the word list II", "abc",
                        new String[]{"cab", "cba"},
                        new String[]{"cab", "cba"},
                        new String[]{"cab", "cba", "asd", "asdfjkafs", "aa"}},
                {
                        "no permutations, but shorter suggestions",
                        "abcd",
                        new String[]{},
                        new String[]{"cab", "cba"},
                        new String[]{"cab", "cba", "asd", "axdr",
                                "asdfjkafs", "aa"}},
                {"only return suggestions that are in wordlist", "abc",
                        new String[]{"abc"}, new String[]{"abc", "cb"},
                        new String[]{"abc", "cb", "bcd"}}};
        return Arrays.asList(data);
    }

    WordList wl;

    @BeforeEach
    public void createWordList() {
        wl = new SimpleWordList();

    }

    @ParameterizedTest
    @MethodSource("data")
    public void sizeShouldGiveTotalNumberOfStoredWords(String message, String tileRack, String[] permutations,
                                                       String[] validSuggestions, String[] words) {
        wl.addAll(Arrays.asList(words));
        assertEquals(words.length, wl.size(), message);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldReturnCorrectAmountOfPermutations(String message, String tileRack, String[] permutations,
                                                        String[] validSuggestions, String[] wordsInWordList) {
        wl.addAll(Arrays.asList(wordsInWordList));
        int permutationCount = permutations.length;
        assertEquals(permutationCount, wl.validWordsUsingAllTiles(tileRack)
                .size(), message);
    }

    /**
     * This is Part of the Deluxe Version
     */

    public void shouldReturnCorrectNumberOfSuggestions(String message, String tileRack, String[] permutations,
                                                       String[] validSuggestions, String[] wordsInWordList) {
        int wordSuggestionCount = validSuggestions.length;
        assertEquals(wordSuggestionCount, wl.allValidWords(tileRack).size(), message);
    }

}
