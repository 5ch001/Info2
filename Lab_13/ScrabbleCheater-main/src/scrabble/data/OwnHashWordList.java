package scrabble.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OwnHashWordList implements WordList {
    private static int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<String>[] table;
    private int size;

    public OwnHashWordList() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        Set<String> validWords = new HashSet<>();
        Set<String> permutations = generatePermutations(tileRackPart);

        for (String permutation : permutations) {
            if (contains(permutation)) {
                validWords.add(permutation);
            }
        }

        return validWords;
    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        Set<String> result = new HashSet<>();
        for (int i = tileRack.length(); i > 0; i--) {
            Set<String> subsets = generateSubsets(tileRack, i);
            for (String subset : subsets) {
                result.addAll(validWordsUsingAllTiles(subset));
            }
        }
        return result;
    }

    @Override
    public boolean add(String word) {
        if (contains(word)) {
            return false; // Word already exists
        }

        int index = hashFunction(word);
        table[index].add(word);
        size++;

        // Check if resizing is needed
        if ((double) size / INITIAL_CAPACITY >= LOAD_FACTOR) {
            resizeTable();
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<String> words) {
        boolean addedAll = true;
        for (String word : words) {
            if (!add(word)) {
                addedAll = false;
            }
        }
        return addedAll;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public WordList initFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    // Helper method to resize the hash table when load factor is exceeded
    private void resizeTable() {
        int newCapacity = table.length * 2;
        LinkedList<String>[] newTable = new LinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        // Rehash all existing elements into the new table
        for (LinkedList<String> list : table) {
            for (String word : list) {
                int newIndex = hashFunction(word) % newCapacity;
                newTable[newIndex].add(word);
            }
        }

        table = newTable;
        INITIAL_CAPACITY = newCapacity;
    }

    // Custom hash function to determine the index
    private int hashFunction(String word) {
        int hash = 7;
        for (int i = 0; i < word.length(); i++) {
            hash = hash * 31 + word.charAt(i);
        }
        return Math.abs(hash) % table.length;
    }

    // Method to check if the word list contains a specific word
    private boolean contains(String word) {
        int index = hashFunction(word);
        return table[index].contains(word);
    }

    private Set<String> generatePermutations(String str) {
        Set<String> permutations = new HashSet<>();
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }

    private void generatePermutationsHelper(String prefix, String remaining, Set<String> permutations) {
        if (remaining.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                generatePermutationsHelper(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1), permutations);
            }
        }
    }

    private Set<String> generateSubsets(String str, int length) {
        Set<String> subsets = new HashSet<>();
        generateSubsetsHelper("", str, length, subsets);
        return subsets;
    }

    private void generateSubsetsHelper(String prefix, String remaining, int length, Set<String> subsets) {
        if (prefix.length() == length) {
            subsets.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                generateSubsetsHelper(prefix + remaining.charAt(i), remaining.substring(i + 1), length, subsets);
            }
        }
    }
}
