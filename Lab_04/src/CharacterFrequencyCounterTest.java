import java.io.*;

public class CharacterFrequencyCounterTest {

    // Method to count character frequencies
    public void count(Reader reader) {
        // Define an array to store the frequencies of characters
        int[] frequencies = new int[26 * 2]; // 26 for lowercase, 26 for uppercase

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            int c;
            // Read characters until end of input
            while ((c = bufferedReader.read()) != -1) {
                if (c >= 'A' && c <= 'Z') {
                    frequencies[c - 'A']++; // Count uppercase letters
                } else if (c >= 'a' && c <= 'z') {
                    frequencies[c - 'a' + 26]++; // Count lowercase letters
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print character frequencies
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println(ch + ": " + frequencies[ch - 'A']);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.println(ch + ": " + frequencies[ch - 'a' + 26]);
        }

        // Find and print the most frequent character
        char mostFrequentChar = findMostFrequentCharacter(frequencies);
        System.out.println("Most frequent character: " + mostFrequentChar);
    }

    // Test method
    public void testCharacterFrequencyCounter() {
        // Test with a string
        String testString = "Hello World!";
        System.out.println("Testing with string: \"" + testString + "\"");
        count(new StringReader(testString));

        // Test with another string
        String anotherTestString = "This is another test string.";
        System.out.println("\nTesting with string: \"" + anotherTestString + "\"");
        count(new StringReader(anotherTestString));

        // Test with a file
        try {
            System.out.println("\nTesting with file input.txt");
            count(new BufferedReader(new FileReader("src/input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to find the most frequent character
    public char findMostFrequentCharacter(int[] frequencies) {
        int maxFrequency = 0;
        char mostFrequentChar = '\0'; // Initialize to null character

        // Iterate over the frequencies array
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (frequencies[ch - 'A'] > maxFrequency) {
                maxFrequency = frequencies[ch - 'A'];
                mostFrequentChar = ch;
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (frequencies[ch - 'a' + 26] > maxFrequency) {
                maxFrequency = frequencies[ch - 'a' + 26];
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }

    public static void main(String[] args) {
        CharacterFrequencyCounterTest test = new CharacterFrequencyCounterTest();
        test.testCharacterFrequencyCounter();
    }
}
