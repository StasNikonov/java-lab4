import java.util.Arrays;

/**
 * Represents the entire text, consisting of an array of sentences.
 */
class Text {
    private final Sentence[] sentences;

    public Text(String text) {
        String cleanedText = text.replaceAll("\\s+", " ").trim();
        this.sentences = Arrays.stream(cleanedText.split("(?<=\\.)|(?<=!)|(?<=\\?)"))
                .map(Sentence::new)
                .toArray(Sentence[]::new);
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }
}