package scrabble.util;

import java.util.Arrays;

public class Permutation {
	private String word;

	public Permutation(String word) {
		this.word = word;
	}

	@Override
	public int hashCode() {
		return getNormalized().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Permutation)) {
			return false;
		}
		Permutation other = (Permutation) obj;
		return Arrays.equals(getNormalized().toCharArray(), other.getNormalized().toCharArray());
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public String getWord() {
		return word;
	}

	public int length() {
		return word.length();
	}
}
