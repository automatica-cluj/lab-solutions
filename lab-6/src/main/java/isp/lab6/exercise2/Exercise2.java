package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        final Dictionary dictionary = Dictionary.getInstance();

        // add single word without synonyms
        final Word firstBook = new Word("book");
        final WordDescription firstBookDescription = new WordDescription("piece of paper", null);
        final boolean isFirstBookAdded = dictionary.addWord(firstBook, firstBookDescription);
        System.out.println("Result = " + isFirstBookAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        // add book with same value (should override)
        final Word secondBook = new Word("book");
        final WordDescription secondBookDescription = new WordDescription("piece of paper", null);
        final boolean isSecondBookAdded = dictionary.addWord(secondBook, secondBookDescription);
        System.out.println("Result = " + isSecondBookAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        // add new book with synonyms which are not in the dictionary
        final Word thirdBook = new Word("thirdBook");
        final WordDescription thirdBookDescription = new WordDescription("thirdBookDescription", createListOfWords(new Word("not found")));
        final boolean isThirdBookAdded = dictionary.addWord(thirdBook, thirdBookDescription);
        System.out.println("Result = " + isThirdBookAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        // add new book with synonyms found in the dictionary
        final Word fourthWord = new Word("fourthWord");
        final WordDescription fourthDescription = new WordDescription("fourthBookDescription", createListOfWords(firstBook));
        final boolean isFourthBookAdded = dictionary.addWord(fourthWord, fourthDescription);
        System.out.println("Result = " + isFourthBookAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        // add new book with more than one synonym
        final Word fifthWord = new Word("fifthWord");
        final WordDescription fifthDescription = new WordDescription("fifthBookDescription", createListOfWords(firstBook, fourthWord));
        final boolean isFifthBookAdded = dictionary.addWord(fifthWord, fifthDescription);
        System.out.println("Result = " + isFifthBookAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        // remove word that does not exist
        final Word sixthWord = new Word("not found word");
        final boolean isSixthWordDeleted = dictionary.deleteWord(sixthWord);
        System.out.println("Result = " + isSixthWordDeleted);
        System.out.println("Dictionary after delete = " + Dictionary.getDictionary());

        // remove word that exists but is not a synonym for other words (fifth word is not a synonym)
        final boolean isSeventhWordDeleted = dictionary.deleteWord(fifthWord);
        System.out.println("Result = " + isSeventhWordDeleted);
        System.out.println("Dictionary after delete = " + Dictionary.getDictionary());

        // remove word that exists and is used as synonym (firstWord)
        final boolean isEightWordDeleted = dictionary.deleteWord(firstBook);
        System.out.println("Result = " + isEightWordDeleted);
        System.out.println("Dictionary after delete = " + Dictionary.getDictionary());

        // search word which does not exist
        final WordDescription notFoundWord = dictionary.searchWord(new Word("not found word"));
        System.out.println("Result = " + notFoundWord);

        // search word which exist
        final WordDescription existingDescription = dictionary.searchWord(new Word("fourthWord"));
        System.out.println("Result = " + existingDescription);

        // find synonyms word not found
        final List<Word> synonymsNotFound = dictionary.findSynonyms(new Word("not found word"));
        System.out.println("Result = " + synonymsNotFound);

        // find synonyms word does not have synonyms
        final List<Word> wordWithoutSynonyms = dictionary.findSynonyms(new Word("fourthWord"));
        System.out.println("Result = " + wordWithoutSynonyms);

        // find synonyms word with at least one synonym
        final Word seventhWord = new Word("seventhWord");
        final WordDescription seventhWordDescription = new WordDescription("seventhWordDescription", createListOfWords(fourthWord));
        final boolean isSeventhWordAdded = dictionary.addWord(seventhWord, seventhWordDescription);
        System.out.println("Result = " + isSeventhWordAdded);
        System.out.println("Dictionary after add = " + Dictionary.getDictionary());

        final List<Word> worthWithSynonyms = dictionary.findSynonyms(new Word("seventhWord"));
        System.out.println("Result = " + worthWithSynonyms);
    }

    private static List<Word> createListOfWords(final Word... words) {
        final List<Word> wordsList = new ArrayList<>();

        for (Word word : words) {
            wordsList.add(word);
        }

        return wordsList;
    }
}
