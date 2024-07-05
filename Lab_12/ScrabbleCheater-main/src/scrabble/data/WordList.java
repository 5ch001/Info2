package scrabble.data;

import java.util.Collection;
import java.util.Set;

public interface WordList {
	public static final int MIN_WORD_LENGTH = 2;
	public static final int ALPHABET_SIZE = 26;
	public static final char FIRST_CHARACTER = 'a';
	public static final char LAST_CHARACTER = 'z';

	/**
	 * returns Permutations of this exact part of the TileRack that are in the
	 * word list.
	 * 
	 * @param tileRackPart
	 * @return
	 */
	Set<String> validWordsUsingAllTiles(String tileRackPart);

	/**
	 * returns all words that can be build with the tileRack, that is,
	 * permutations of all subsets of the tileRack.
	 * 
	 * @param tileRack
	 * @return
	 */
	Set<String> allValidWords(String tileRack);

	/**
	 * adds a single word to the word list
	 * 
	 * @param word
	 * @return
	 */
	public boolean add(String word);

	/**
	 * adds all words in the collection to the WordList.
	 * 
	 * @param words
	 * @return
	 */
	public boolean addAll(Collection<String> words);

	/**
	 * returns the number of stored words.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * initializes this wordList from the given File.
	 * 
	 * @param fileName
	 * @return
	 */
	public WordList initFromFile(String fileName);
}
