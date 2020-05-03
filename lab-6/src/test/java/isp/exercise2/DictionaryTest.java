package isp.exercise2;

import isp.lab6.exercise2.Dictionary;
import isp.lab6.exercise2.Word;
import isp.lab6.exercise2.WordDescription;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {
    @Before
    public void setUP() {
        // clean up the dictionary before each test
        Dictionary.getInstance().clearDictionary();
    }

    @Test
    public void testAddWordWithoutSynonyms() {
        // given
        final Word word = new Word("new word");
        final WordDescription wordDescription = new WordDescription("new word description", null);

        // when
        final boolean result = Dictionary.getInstance().addWord(word, wordDescription);

        // then
        assertEquals("Result should be true", true, result);
        assertEquals("Size of dictionary should be 1", 1, Dictionary.getDictionary().size());
    }

    @Test
    public void testAddWordWithEmptyList() {
        // given
        final Word word = new Word("new word");
        final WordDescription wordDescription = new WordDescription("new word description", null);

        // when
        final boolean result = Dictionary.getInstance().addWord(word, wordDescription);

        // then
        assertEquals("Result should be true", true, result);
        assertEquals("Size of dictionary should be 1", 1, Dictionary.getDictionary().size());

        // given
        final Word word2 = new Word("new word2");
        final WordDescription wordDescription2 = new WordDescription("new word description", Arrays.asList(word));

        // when
        final boolean result2 = Dictionary.getInstance().addWord(word2, wordDescription2);

        // then
        assertEquals("Result should be true", true, result2);
        assertEquals("Size of dictionary should be 2", 2, Dictionary.getDictionary().size());

        assertEquals("Synonyms should be the same", Arrays.asList(new Word("new word")), Dictionary.getInstance().findSynonyms(new Word("new word2")));
    }
}
