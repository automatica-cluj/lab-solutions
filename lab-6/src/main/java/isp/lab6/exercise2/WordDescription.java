package isp.lab6.exercise2;

import java.util.List;

public class WordDescription {
    private String description;
    private List<Word> synonyms;

    public WordDescription(String description, List<Word> synonyms) {
        this.description = description;
        this.synonyms = synonyms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Word> synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "WordDescription{" +
                "description='" + description + '\'' +
                ", synonyms=" + synonyms +
                '}';
    }
}
