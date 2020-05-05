package isp.lab6.exercise2;

import isp.lab6.exercise2.utils.WordUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class DictionaryTest {
    @Before
    public void setUp() {
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
        assertTrue("Result should be true", result);
        assertEquals("Size of dictionary should be 1", 1, Dictionary.getInstance().getNumberOfWords());
        assertWordAndWordDescription(word, wordDescription);
    }

    @Test
    public void testAddWordWithEmptyList() {
        // given
        final Word word = new Word("new word");
        final WordDescription wordDescription = new WordDescription("new word description", null);

        // when
        final boolean result = Dictionary.getInstance().addWord(word, wordDescription);

        // then
        assertTrue("Result should be true", result);
        assertEquals("Size of dictionary should be 1", 1, Dictionary.getInstance().getNumberOfWords());
        assertWordAndWordDescription(word, wordDescription);

        // given
        final Word word2 = new Word("new word2");
        final WordDescription wordDescription2 = new WordDescription("new word description", singletonList(word));

        // when
        final boolean result2 = Dictionary.getInstance().addWord(word2, wordDescription2);

        // then
        assertTrue("Result should be true", result2);
        assertEquals("Size of dictionary should be 2", 2, Dictionary.getInstance().getNumberOfWords());
        assertWordAndWordDescription(word, wordDescription);
        assertWordAndWordDescription(word2, wordDescription2);
    }

    @Test
    public void testAddWordWithSynonymsNotFound() {
        // given
        final Word word = new Word("new word");
        final WordDescription wordDescription = new WordDescription("new word description", Arrays.asList(new Word("NOT_FOUND_WORD")));

        // when
        final boolean result = Dictionary.getInstance().addWord(word, wordDescription);

        // then
        assertFalse("Result should be false", result);
        assertEquals("Size of the dictionary should be 0", 0, Dictionary.getInstance().getNumberOfWords());
    }

    @Test
    public void testAddWordWithSynonyms() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", Collections.emptyList());
        final Word secondWord = new Word("Second word");
        final WordDescription secondWordDescription = new WordDescription("second word description", Collections.singletonList(firstWord));
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));

        // when
        final boolean result = Dictionary.getInstance().addWord(secondWord, secondWordDescription);

        // then
        assertTrue("Result should be true", result);
        assertEquals("Size of the dictionary should be 2", 2, Dictionary.getInstance().getNumberOfWords());
        assertWordAndWordDescription(firstWord, firstWordDescription);
        assertWordAndWordDescription(secondWord, secondWordDescription);
    }

    @Test
    public void testDeleteWordNotFound() {
        // when
        final boolean result = Dictionary.getInstance().deleteWord(new Word("NOT_FOUND"));

        // then
        assertFalse("Result should be false", result);
    }

    @Test
    public void testDeleteWordWithoutSynonyms() {
        // given
        final Word word = new Word("new word");
        final WordDescription wordDescription = new WordDescription("new word description", Collections.emptyList());
        Dictionary.getInstance().addWord(word, wordDescription);

        // when
        final boolean result = Dictionary.getInstance().deleteWord(word);

        // then
        assertTrue("Result should be true", result);
        assertEquals("Size of the dictionary should be 0", 0, Dictionary.getInstance().getNumberOfWords());
    }

    @Test
    public void testDeleteWordDeletesAlsoFromSynonyms() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", Collections.emptyList());
        final Word secondWord = new Word("Second word");
        final WordDescription secondWordDescription = new WordDescription("second word description", WordUtils.createListOfWords(firstWord));
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));
        assertTrue("Result should be true", Dictionary.getInstance().addWord(secondWord, secondWordDescription));

        // when
        final boolean result = Dictionary.getInstance().deleteWord(firstWord);

        // then
        assertTrue("Result should be true", result);
        assertEquals("Size of the dictionary should be 1", 1, Dictionary.getInstance().getNumberOfWords());
        assertWordAndWordDescription(secondWord, new WordDescription("second word description", Collections.emptyList())); // only second word should remain in the system
    }

    @Test
    public void testSearchWordNotFound() {
        // when
        final WordDescription result = Dictionary.getInstance().searchWord(new Word("NOT_FOUND"));

        // then
        assertNull("Result should be null", result);
    }

    @Test
    public void testSearchWordReturnsCorrectData() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", Collections.emptyList());
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));

        // when
        final WordDescription result = Dictionary.getInstance().searchWord(firstWord);

        // then
        assertNotNull("Result should not be null", result);
        assertEquals("Word description should be the same", firstWordDescription, result);
    }

    @Test
    public void testFindSynonymsReturnsNullForNotFoundWord() {
        // when
        final List<Word> result = Dictionary.getInstance().findSynonyms(new Word("NOT_FOUND"));

        // then
        assertNull("Result should be null", result);
    }

    @Test
    public void testFindSynonymsReturnsNullForWordWithoutSynonyms() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", null);
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));

        // when
        final List<Word> result = Dictionary.getInstance().findSynonyms(firstWord);

        // then
        assertNull("Result should be null", result);
    }

    @Test
    public void testFindSynonymsReturnsEmptyForWordWithoutSynonyms() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", Collections.emptyList());
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));

        // when
        final List<Word> result = Dictionary.getInstance().findSynonyms(firstWord);

        // then
        assertNotNull("Result should not be null", result);
        assertEquals("Result should be empty list", Collections.emptyList(), result);
    }

    @Test
    public void testFindSynonymsReturnsSynonyms() {
        // given
        final Word firstWord = new Word("First word");
        final WordDescription firstWordDescription = new WordDescription("first word description", Collections.emptyList());
        final Word secondWord = new Word("Second word");
        final WordDescription secondWordDescription = new WordDescription("second word description", WordUtils.createListOfWords(firstWord));
        assertTrue("Result should be true", Dictionary.getInstance().addWord(firstWord, firstWordDescription));
        assertTrue("Result should be true", Dictionary.getInstance().addWord(secondWord, secondWordDescription));

        // when
        final List<Word> result = Dictionary.getInstance().findSynonyms(secondWord);

        // then
        assertNotNull("Result should not be null", result);
        assertEquals("Result should contain only first word", Collections.singletonList(firstWord), result);
    }

    private void assertWordAndWordDescription(Word expectedWord, WordDescription expectedWordDescription) {
        final WordDescription wordDescription = Dictionary.getInstance().searchWord(expectedWord);
        assertNotNull("Word description should not be null", wordDescription);
        assertEquals("Word description should be the same", expectedWordDescription, wordDescription);
    }
}
