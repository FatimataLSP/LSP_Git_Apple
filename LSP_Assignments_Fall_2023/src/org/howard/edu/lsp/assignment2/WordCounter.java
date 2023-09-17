package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            // Provide the path to the text file you want to count words in
            reader = new BufferedReader(new FileReader("/Users/tima/git/LSP_Git_Apple/LSP_Assignments_Fall_2023/main.java.resource/words.txt"));
            String line = reader.readLine();

            // Create a map to store word counts
            Map<String, Integer> wordCounts = new HashMap<>();

            while (line != null) {
                // Split the line into words
                String[] words = line.split(" ");

                for (String word : words) {
                    // Trim leading/trailing spaces and convert to lowercase
                    word = word.trim().toLowerCase();

                    if (!word.isEmpty() && !isNumeric(word)) { // Check if the word is not empty and not numeric
                        // Update word count in the map
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }

                // Read the next line
                line = reader.readLine();
            }

            // Print the word counts
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }

            reader.close(); // Don't forget to close the reader when done.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
