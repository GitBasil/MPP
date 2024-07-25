package One.prob4_exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordGame {
	// This method throws an IllegalWordException
	// Find a way to handle it. Use best practices

	public List<String> adjustWords(List<String> words) {
//		 return words.stream().map(w ->
//		 verifyWord(w).toLowerCase()).collect(Collectors.toList());
		return words.stream().map(w -> ver(w)).collect(Collectors.toList());
	}

	public String ver(String word) {
		try {
			return verifyWord(word.toLowerCase());
		} catch (IllegalWordException e) {
			throw new RuntimeException();
		}

	}

	private String verifyWord(String word) throws IllegalWordException {
		if ("A, B, C, E, M, N, R, S, T".contains("" + word.charAt(0))) {
			throw new IllegalWordException("The first letter of " + word + " contains one of the illegal characters.");
		}
		return word;
	}

	public static void main(String[] args) {
		List<String> sampleList1 = Arrays.asList("Dog", "Horse", "Peanut", "Pepper", "Inch");
		List<String> sampleList2 = Arrays.asList("Dog", "Horse", "Peanut", "Mother", "Detergent");
		WordGame wg = new WordGame();

		// uncomment when you are ready
		System.out.println(wg.adjustWords(sampleList1));
		System.out.println(wg.adjustWords(sampleList2));
	}

}
