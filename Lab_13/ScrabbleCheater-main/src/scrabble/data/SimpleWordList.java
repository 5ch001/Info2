package scrabble.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
		return wordSet.add(word);
	}

	@Override
	public boolean addAll(Collection<String> words) {
		return wordSet.addAll(words);
	}

	@Override
	public int size() {
		return wordSet.size();
	}

	private String normalize(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
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
