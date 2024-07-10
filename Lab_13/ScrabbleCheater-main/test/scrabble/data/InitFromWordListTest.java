package scrabble.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitFromWordListTest {
	@Test
	public void initFromFile() {
		WordList wl = new SimpleWordList()
				.initFromFile("wordlists/sowpods.txt");
		assertEquals(267751, wl.size(),
				"Task1: initFromFile / words should be stored in wordlist");
	}
}
