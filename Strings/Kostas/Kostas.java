import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Kostas {

	private static HashMap<Character, String> alphaKey;

	/**
	 * Contains alphabet to leet conversion.
	 */
	private static void setUpMap() {
		alphaKey = new HashMap<>();
		alphaKey.put('A', "4");
		alphaKey.put('B', "8");
		alphaKey.put('C', "[");
		alphaKey.put('D', ")");
		alphaKey.put('E', "3");
		alphaKey.put('F', "l=");
		alphaKey.put('G', "6");
		alphaKey.put('H', "#");
		alphaKey.put('I', "|");
		alphaKey.put('J', "]");
		alphaKey.put('K', "|<");
		alphaKey.put('L', "1");
		alphaKey.put('M', "^^");
		alphaKey.put('N', "^");
		alphaKey.put('O', "0");
		alphaKey.put('P', "|o");
		alphaKey.put('Q', "9");
		alphaKey.put('R', "2");
		alphaKey.put('S', "5");
		alphaKey.put('T', "7");
		alphaKey.put('U', "(_)");
		alphaKey.put('V', "\\/");
		alphaKey.put('W', "vv");
		alphaKey.put('X', "><");
		alphaKey.put('Y', "/");
		alphaKey.put('Z', "%");
	}

	/**
	 * Encode each word in the sentence using leet.
	 * 
	 * @param input
	 */
	private static void process(String input) {
		String[] words = input.split(" ");
		for (int i = 0; i < words.length; i++)
			words[i] = encode(words[i]);

		for (String a : words)
			System.out.print(a + " ");
		System.out.println();

	}

	/**
	 * Encode the given word according to the problem specifications.
	 * 
	 * @param word
	 * @return
	 */
	private static String encode(String word) {

		// \\b means word boundary (end of word in this case)
		word = word.replaceAll("(OR\\b)", "ZOR");
		word = word.replaceAll("(ER\\b)", "XOR");
		word = word.replaceAll("(AND\\b)|(ANNED\\b)|(ANT\\b)", "&");
		word = word.replaceAll("(ED\\b)", "*D");

		if (word.endsWith("XOR") || word.endsWith("ZOR")) {
			for (int i = 0; i < word.length() - 3; i++) {
				char charAtI = word.charAt(i);
				if (!Character.isDigit(charAtI)) {
					word = word.substring(0, i) + alphaKey.get(charAtI) + word.substring(i + 1);
					i += alphaKey.get(charAtI).length() - 1;
				}
			}
		}

		else if (word.endsWith("*D")) {
			for (int i = 0; i < word.length() - 2; i++) {
				char charAtI = word.charAt(i);
				if (!Character.isDigit(charAtI)) {
					word = word.substring(0, i) + alphaKey.get(charAtI) + word.substring(i + 1);
					i += alphaKey.get(charAtI).length() - 1;
				}
			}
		}

		else if (word.endsWith("&")) {
			for (int i = 0; i < word.length() - 1; i++) {
				char charAtI = word.charAt(i);
				if (!Character.isDigit(charAtI)) {
					word = word.substring(0, i) + alphaKey.get(charAtI) + word.substring(i + 1);
					i += alphaKey.get(charAtI).length() - 1;
				}
			}
		} else {
			for (int i = 0; i < word.length(); i++) {
				char charAtI = word.charAt(i);
				if (!Character.isDigit(charAtI)) {
					word = word.substring(0, i) + alphaKey.get(charAtI) + word.substring(i + 1);
					i += alphaKey.get(charAtI).length() - 1;
				}

			}
		}

		return word;
	}

	/**
	 * Process input and handle accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		setUpMap();
		Scanner scan = new Scanner(new File("kostas.dat"));
		while (scan.hasNextLine())
			process(scan.nextLine());
		scan.close();
	}

}
