package scrabble.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SubSetsTest {

	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "a", new String[] {} },
				{ "ab", new String[] { "ab" } },
				{
						"java",
						new String[] { "aajv", "ajv", "aaj", "aav", "aa", "aj",
								"av", "jv" } },
				{
						"abcd",
						new String[] { "ab", "ac", "ad", "bc", "bd", "cd",
								"abc", "abd","bcd","acd","abcd" } } });
	}

	String str;
	Set<String> expected;

	public SubSetsTest(String str, String[] list) {
		this.str = str;
		this.expected = new HashSet<String>(Arrays.asList(list));
	}

	//@Ignore
	public void testComputeSubSets(String str, String[] list) {
		Set<String> actual = SubSets.getSubSets(str);
		assertEquals(expected, actual);
	}
	@ParameterizedTest
	@MethodSource("data")
	public void testNothing(String str, String[] list) {
		// just to avoid to get the No runnable methods error, can be deleted
		// if the @Ignore above is changed to @Test
	}

}
