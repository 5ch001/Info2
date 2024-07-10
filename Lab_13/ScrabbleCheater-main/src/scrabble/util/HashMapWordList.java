package scrabble.util;

import scrabble.data.WordList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HashMapWordList implements WordList {
    private Map<String, Permutation> wordMap;

    public HashMapWordList() {
        this.wordMap = new HashMap<>();
    }

    @Override
    public WordList initFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                if (!word.isEmpty()) {
                    Permutation permutation = new Permutation(word);
                    wordMap.put(permutation.getNormalized(), permutation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        Set<String> validWords = new HashSet<>();
        Permutation tileRackPerm = new Permutation(tileRackPart);
        String normalizedTileRack = tileRackPerm.getNormalized();

        for (Permutation permutation : wordMap.values()) {
            if (permutation.length() == tileRackPart.length() && permutation.getNormalized().equals(normalizedTileRack)) {
                validWords.add(permutation.getWord());
            }
        }

        return validWords;
    }

    @Override
    public Set<String> allValidWords(String tileRack) {
        Set<String> validWords = new HashSet<>();
        Permutation tileRackPerm = new Permutation(tileRack);
        String normalizedTileRack = tileRackPerm.getNormalized();

        for (Permutation permutation : wordMap.values()) {
            if (isPermutationOf(permutation, normalizedTileRack)) {
                validWords.add(permutation.getWord());
            }
        }

        return validWords;
    }

    private boolean isPermutationOf(Permutation perm, String normalizedTileRack) {
        if (perm.length() != normalizedTileRack.length()) {
            return false;
        }

        char[] permChars = perm.getNormalized().toCharArray();
        char[] rackChars = normalizedTileRack.toCharArray();
        Arrays.sort(permChars);
        Arrays.sort(rackChars);

        return Arrays.equals(permChars, rackChars);
    }

    @Override
    public boolean add(String word) {
        Permutation permutation = new Permutation(word);
        String normalizedForm = permutation.getNormalized();
        if (!wordMap.containsKey(normalizedForm)) {
            wordMap.put(normalizedForm, permutation);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<String> words) {
        boolean modified = false;
        for (String word : words) {
            if (add(word)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public int size() {
        return wordMap.size();
    }
}
