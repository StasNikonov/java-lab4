import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class containing the entry point and text processing logic.
 */
public class Main {

    /**
     * Processes the text to remove the longest substring starting and ending
     * with the specified characters.
     *
     * @param text      The input text.
     * @param startChar The starting character for the substring.
     * @param endChar   The ending character for the substring.
     * @return The processed text.
     */
    public static String processText(String text, char startChar, char endChar) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        Text parsedText = new Text(text);
        StringBuilder result = new StringBuilder();

        for (Sentence sentence : parsedText.getSentences()) {
            String regex = String.format("%s.*?%s",
                    Pattern.quote(String.valueOf(startChar)),
                    Pattern.quote(String.valueOf(endChar)));
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence.getOriginalSentence());

            String modifiedSentence = sentence.getOriginalSentence();
            String longestSubstring = null;

            while (matcher.find()) {
                String currentSubstring = matcher.group();
                if (longestSubstring == null || currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
            }

            if (longestSubstring != null) {
                modifiedSentence = modifiedSentence.replace(longestSubstring, "").trim();
            }

            result.append(modifiedSentence).append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Main entry point for the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the text:");
            String inputText = scanner.nextLine();

            System.out.println("Enter the starting character:");
            char startChar = scanner.next().charAt(0);

            System.out.println("Enter the ending character:");
            char endChar = scanner.next().charAt(0);

            String result = processText(inputText, startChar, endChar);
            System.out.println("Processed text:");
            System.out.println(result);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}

