package scrabble.data;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleWordList implements WordList {
	private Set<String> wordSet;
	private Map<String, String> normalizedCache;

	public SimpleWordList() {
		this.wordSet = new HashSet<>();
		this.normalizedCache = new HashMap<>();
	}

	@Override
	public WordList initFromFile(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String word = line.trim();
				if (!word.isEmpty()) {
					wordSet.add(word);
					String normalizedForm = normalize(word);
					normalizedCache.put(normalizedForm, word);
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
		Set<String> permutations = generatePermutations(tileRackPart);

		for (String permutation : permutations) {
			String normalizedForm = normalize(permutation);
			if (normalizedCache.containsKey(normalizedForm)) {
				String originalWord = normalizedCache.get(normalizedForm);
				if (wordSet.contains(originalWord)) {
					validWords.add(originalWord);
				}
			}
		}

		return validWords;
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		// Implementation for this method
		return null;
	}

	@Override
	public boolean add(String word) {
		// Implementation for this method
		return false;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		// Implementation for this method
		return false;
	}

	@Override
	public int size() {
		// Implementation for this method
		return wordSet.size();
	}

	private String normalize(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	private Set<String> generatePermutations(String str) {
		// Implementation of permutation generation
		// This method is assumed to generate permutations as needed
		return new HashSet<>();
	}
}
