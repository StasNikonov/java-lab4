import java.util.Arrays;

/**
 * Represents a single sentence, consisting of an array of words and punctuation marks.
 */
class Sentence {
    private final String originalSentence;
    private final Word[] words;

    public Sentence(String sentence) {
        this.originalSentence = sentence;
        this.words = Arrays.stream(sentence.split("\\s+"))
                .map(Word::new)
                .toArray(Word[]::new);
    }

    public Word[] getWords() {
        return words;
    }

    public String getOriginalSentence() {
        return originalSentence;
    }

    @Override
    public String toString() {
        return originalSentence;
    }
}
