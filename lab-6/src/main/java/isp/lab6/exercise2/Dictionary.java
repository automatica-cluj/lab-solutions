package isp.lab6.exercise2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Dictionary {
    private static Dictionary INSTANCE;
    private static Map<Word, WordDescription> dictionary;

    private Dictionary() {
    }

    public static Dictionary getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Dictionary();
            dictionary = new HashMap<>();
        }

        return INSTANCE;
    }

    public static Map<Word, WordDescription> getDictionary() {
        return dictionary;
    }

    /**
     * Add new word in dictionary
     *
     * @param word            - instance of {@link Word} object to be added
     * @param wordDescription - instance of {@link WordDescription} to be added with provided word
     * @return true if the word was successfully added or false if a particular synonym was not found in the dictionary
     */
    public boolean addWord(final Word word, final WordDescription wordDescription) {
        Objects.requireNonNull(word, "Word is null");
        Objects.requireNonNull(wordDescription, "Word Description is null");

        if (!this.areWordsInDictionary(wordDescription.getSynonyms())) {
            System.out.println("[WARN] At least one synonym not found in the dictionary.");
            return false;
        }

        dictionary.put(word, wordDescription);
        return true;
    }

    /**
     * Delete a word from the dictionary
     *
     * @param word - instance of {@link Word} object to be added
     * @return true if the word was found and successfully deleted or false if a particular synonym was not found
     */
    public boolean deleteWord(final Word word) {
        if (!dictionary.containsKey(word)) {
            System.out.println("[WARN] Word with value " + word.getValue() + " not found in the dictionary");
            return false;
        }

        // delete this word from all synonyms
        dictionary
                .entrySet()
                .stream()
                .forEach(wordWordDescriptionEntry -> {
                    final WordDescription wordDescription = wordWordDescriptionEntry.getValue();

                    if (Objects.nonNull(wordDescription.getSynonyms())) {
                        wordDescription.getSynonyms().remove(word);
                    }
                });

        // remove word from dictionary
        dictionary.remove(word);
        return true;
    }

    /**
     * Get description for a particular word
     *
     * @param word - instance of {@link Word} object to be searched
     * @return instance of {@link WordDescription} or null if not found
     */
    public WordDescription searchWord(final Word word) {
        return dictionary.get(word);
    }

    /**
     * Find synonyms for a particular word
     *
     * @param word - instance of {@link Word} object to be searched
     * @return list of existing synonyms, null if the word not found or no synonyms are found for it
     */
    public List<Word> findSynonyms(final Word word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word).getSynonyms();
        }

        return null;
    }

    /**
     * Clear all words from current dictionary
     */
    public void clearDictionary() {
        dictionary.clear();
    }

    /**
     * Check if all provided words exists in the dictionary
     *
     * @param words - list of words to be validated
     * @return true if all words already exits in the dictionary, false otherwise
     * @apiNote: if input is null, true will be returned
     */
    private boolean areWordsInDictionary(final List<Word> words) {
        if (Objects.isNull(words)) {
            return true;
        }

        return dictionary.keySet().containsAll(words);
    }
}
