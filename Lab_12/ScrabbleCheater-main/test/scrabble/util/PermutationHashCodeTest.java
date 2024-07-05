package scrabble.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PermutationHashCodeTest {

	String string1, string2;
	     public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { "hallo", "lloha" }, { "otto", "toto" }, { "imi", "mii" },
	                 { "a","a" }, { "","" }, { "ab","ba" }, { "wundertuete","ertuetwunde" }, { "","" }
	           });
	    }

	public PermutationHashCodeTest() {

				}
	@ParameterizedTest
	@MethodSource("data")
	public void hashCodeForPermutationsShouldBeTheSame(String string1, String string2) {
			Permutation permutation1 = new Permutation(string1);
			Permutation permutation2 = new Permutation(string2);
			assertEquals(permutation1, permutation2);
			assertEquals(permutation1.hashCode(), permutation2.hashCode());
		}
}
