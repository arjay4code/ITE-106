 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
    public static void main(String[] args) {
        String filePath = "textfile.txt";
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        String content = fileContent.toString().trim();
        String[] words = content.split("\\s+");

        System.out.println("Word Count: " + words.length);
        System.out.println("Sentence Count: " + countSentences(content));
        System.out.println("Text in Uppercase:\n" + content.toUpperCase());
        System.out.println("Longest Word: " + findLongestWord(words));
    }

    private static int countSentences(String text) {
        int count = 0;
        for (String sentence : text.split("[.!?]")) {
            if (!sentence.trim().isEmpty()) count++;
        }
        return count;
    }

    private static String findLongestWord(String[] words) {
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        return longest;
    }
}
