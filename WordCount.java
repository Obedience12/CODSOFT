import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Word Count!");

        // where we prompt our user to enter text or give a file

        System.out.print("Enter 'text' to input text of 'file' to input a file: ");
        String inputMsg = scan.nextLine().toLowerCase();

        String textmsg = "";

        // we read the input txt or file and store it in a string

        if (inputMsg.equals("text")) {
            System.out.print("Enter your text: ");
            textmsg = scan.nextLine();
        } else if (inputMsg.equals("file")) {
            System.out.print("Enter the path to the file: ");
            String filePath = scan.nextLine();
            try {
                textmsg = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
                scan.close();
                return;
            }
        } else {
            System.out.println("Invalid input. Please enter 'text' or 'file'.");
            scan.close();
            return;
        }

        // we split the string into an array of words
        String[] words = textmsg.split("[\\s\\p{Punct}]+");

        // we initialize a counter variable
        int wordCounter = 0;

        // iterate through the array of words and increment the counter
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounter++;
            }
        }

        // we show the total count of words to the user
        System.out.println("Total words: " + wordCounter);

        analyzeText(words);

        scan.close();
    }

    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder context = new StringBuilder();
        Scanner fileScan = new Scanner(new File(filePath));

        while (fileScan.hasNextLine()) {
            context.append(fileScan.nextLine()).append("\n");
        }

        fileScan.close();
        return context.toString();
    }

    private static void analyzeText(String[] words) {
        String[] stopWords = { "the", "and", "is", "in", "it", "of", "to", "this" };

        Map<String, Integer> wordFrequency = new HashMap<>();

        int uniqueWords = 0;

        for (String word : words) {
            if (!word.isEmpty() && !isStopWord(word, stopWords)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                uniqueWords++;
            }
        }

        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Word frequency:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }

        return false;
    }

}