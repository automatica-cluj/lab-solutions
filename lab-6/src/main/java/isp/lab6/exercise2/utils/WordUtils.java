package isp.lab6.exercise2.utils;

import isp.lab6.exercise2.Word;

import java.util.ArrayList;
import java.util.List;

public class WordUtils {
    private WordUtils() {
    }

    /**
     * Create dynamic list of words
     *
     * @param words - list of words to be added to array list
     * @return instance of {@link List<Word>}
     */
    public static List<Word> createListOfWords(final Word... words) {
        final List<Word> wordsList = new ArrayList<>();

        for (Word word : words) {
            wordsList.add(word);
        }

        return wordsList;
    }
}
