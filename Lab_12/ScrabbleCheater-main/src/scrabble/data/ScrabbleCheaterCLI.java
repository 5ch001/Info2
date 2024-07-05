package scrabble.data;

import scrabble.util.HashMapWordList;

import java.util.Scanner;
import java.util.Set;

public class ScrabbleCheaterCLI {

    private static WordList wordList;

    public static void main(String[] args) {
        // Initialize your WordList implementation
        wordList = new HashMapWordList();
        wordList.initFromFile("words.txt");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display instructions
        System.out.println("Welcome to Scrabble Cheater!");
        System.out.println("Enter '1' to find valid words using all tiles from a tile rack.");
        System.out.println("Enter '2' to find if a specific word is a valid Scrabble word.");
        System.out.println("Enter '0' to exit.");

        // Handle user input
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter your tile rack: ");
                    String tileRack = scanner.nextLine().trim().toUpperCase();
                    Set<String> validWords = wordList.validWordsUsingAllTiles(tileRack);
                    System.out.println("Valid words using tiles " + tileRack + ": " + validWords);
                    break;
                case "2":
                    System.out.print("Enter the word to check: ");
                    String word = scanner.nextLine().trim().toUpperCase();
                    boolean isWordValid = wordList.add(word); // Check if word exists in word list
                    System.out.println("The word '" + word + "' is " + (isWordValid ? "valid." : "not valid."));
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter '1', '2', or '0'.");
                    break;
            }
        }

        // Close scanner
        scanner.close();
    }
}
