/**
 * Represents a single word, consisting of an array of letters.
 */
class Word {
    private final Letter[] letters;

    public Word(String word) {
        this.letters = word.chars().mapToObj(c -> new Letter((char) c)).toArray(Letter[]::new);
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}