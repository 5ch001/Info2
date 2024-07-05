package scrabble.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class SowPodsTest {

	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{

						"querdze",
						new String[] {},
						new String[] { "rud", "deer", "de", "dree", "rede",
								"queer", "rue", "dee", "red", "ree", "rued",
								"zed", "ere", "dere", "zee", "ur", "ed", "ee",
								"urdee", "ered", "urd", "rez", "reed", "urde",
								"ure", "dure", "er", "rude", "re", "due" } },
				{

						"gustable",
						new String[] { "gustable" },
						new String[] { "tub", "aglu", "glue", "blagues",
								"lugs", "tug", "beaus", "slae", "beaut", "bag",
								"lea", "slag", "seta", "bal", "ates", "tsuba",
								"leg", "slab", "bates", "tea", "gulas",
								"stela", "bat", "bas", "luge", "eaus", "teg",
								"baste", "suba", "legs", "saute", "let", "tel",
								"beluga", "les", "butles", "tales", "leu",
								"baguet", "glutes", "ugs", "ab", "butle",
								"tes", "teguas", "begat", "ae", "ag", "balu",
								"ablest", "bals", "bute", "al", "gues", "bets",
								"tags", "seat", "as", "at", "ales", "eats",
								"gustable", "bleats", "guest", "buts", "ba",
								"begs", "sub", "sue", "abuse", "be", "ablets",
								"least", "sublate", "sea", "lubes", "bugs",
								"seg", "teas", "blet", "sel", "gaults", "st",
								"egal", "set", "salt", "tabus", "abets",
								"suable", "teal", "salue", "ta", "blast", "te",
								"stag", "subtle", "sale", "abs", "glut",
								"stab", "blue", "stage", "bug", "abuts",
								"slat", "gault", "agues", "blase", "but",
								"bus", "latu", "beg", "lats", "bel", "setal",
								"gast", "bulge", "slut", "blets", "beauts",
								"tale", "bet", "bes", "ug", "slub", "ate",
								"late", "taubes", "gusla", "stub", "gabs",
								"ea", "gusle", "slue", "baguets", "slug", "us",
								"bastle", "ut", "tubs", "last", "leats", "el",
								"suet", "elt", "abut", "els", "es", "ule",
								"et", "aue", "tube", "labs", "lase", "tuba",
								"belga", "abet", "guls", "gaus", "saulge",
								"gab", "gae", "beast", "bluet", "bast",
								"blues", "salute", "sable", "bats", "gates",
								"usable", "gula", "gal", "gels", "gelt",
								"gule", "gas", "geats", "gales", "gau", "gat",
								"bate", "beats", "belugas", "gats", "bales",
								"talus", "galuts", "gu", "tubes", "buats",
								"balus", "bugles", "buglet", "gate", "age",
								"base", "glues", "luges", "teals", "usage",
								"sublet", "bael", "sate", "ags", "etas",
								"bulse", "tables", "lags", "stale", "blags",
								"betas", "gables", "ague", "gablet", "tugs",
								"slate", "sabe", "bels", "belt", "utas",
								"galut", "tegu", "tegs", "sault", "gub", "gue",
								"gaes", "bluets", "bagel", "gul", "gablets",
								"gus", "bags", "gut", "tabs", "elts", "belgas",
								"gel", "saul", "eas", "get", "besat", "saut",
								"eau", "bluest", "leas", "eat", "tubages",
								"bleat", "belts", "leat", "table", "tules",
								"bagels", "tegula", "tubas", "blest", "gluts",
								"butes", "la", "tubal", "bugle", "able",
								"ages", "taube", "tubae", "glute", "blats",
								"gleba", "albe", "tesla", "use", "est", "lute",
								"lets", "buglets", "lab", "tule", "bustle",
								"gules", "tels", "gest", "salet", "taels",
								"gubs", "tela", "albs", "tabes", "eta", "lag",
								"tab", "blaest", "gelts", "alb", "lust",
								"beat", "gable", "sage", "beau", "tae", "ale",
								"tag", "lat", "blate", "baels", "las", "geat",
								"aglus", "uta", "tegus", "tas", "ute", "lest",
								"alt", "tau", "als", "tegua", "aglet", "ules",
								"uts", "tabu", "geal", "aglets", "utes",
								"lube", "blae", "steal", "lues", "alts",
								"seal", "best", "sagbut", "tubage", "lutea",
								"geals", "gals", "lutes", "blaes", "east",
								"blat", "getas", "sab", "bale", "sae", "sag",
								"blague", "bust", "ables", "guts", "beta",
								"blag", "ablet", "sal", "bulges", "tael",
								"gale", "sau", "sat", "buat", "gets", "taes",
								"stable", "geta", "taus", "lug", "gust" } },
				{

						"siszymo",
						new String[] { "zymosis" },
						new String[] { "ism", "mossy", "iso", "moi", "ios", "moys", "mos", "som", "sos", "moy", "yom", "yo", "moz", "soy", "yos", "mi", "sizy", "mo", "io", "is", "my", "moss", "zo", "soms", "somy", "isos", "soys", "zoism", "oys", "sims", "misos", "miso", "missy", "miss", "oms", "si", "mis", "sim", "oi", "sis", "so", "om", "zos", "miz", "isms", "os", "myosis", "oy", "zoisms", "zymosis" } } };

		return Arrays.asList(data);
	}

	String tileRack;
	String[] validSuggestions, permutations;
	static WordList wl;

	public SowPodsTest(String tileRack, String[] permutations,
			String[] validSuggestions) {
		this.validSuggestions = validSuggestions;
		this.permutations = permutations;
		this.tileRack = tileRack;
	}

	@BeforeAll
	public static void createWordList() {
		wl = new SimpleWordList().initFromFile("wordlists/sowpods.txt");
	}

	@ParameterizedTest
	@MethodSource("data")
	public void sizeShouldGiveTotalNumberOfStoredWords(String tileRack, String[] permutations,
													   String[] validSuggestions) {
		assertEquals(267751, wl.size(), tileRack);
	}

	// Ignore
	public void shouldReturnCorrectPermutations(String tileRack, String[] permutations,
												String[] validSuggestions) {
		Set<String> actual = wl.validWordsUsingAllTiles(tileRack);
		// assertEquals(message, permutations.length, actual.size());
		List<Integer> permutationsList =
				Arrays.stream(permutations).map(i->new Integer(i)).collect(Collectors.toList());
		;
		assertEquals( new HashSet<String>(permutationsList.size()),
				actual, tileRack);
	}
	/**
	 * This is Part of the Deluxe Version
	 */
	//@Ignore
	public void shouldReturnCorrectSuggestions() {
		Set<String> actual = wl.allValidWords(tileRack);
		// assertEquals(message, validSuggestions.length,
		// wl.words(tileRack).size());
		assertEquals(
				new HashSet<String>(Arrays.asList(validSuggestions)), actual, tileRack);
	}

}
