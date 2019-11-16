package strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class pr37 {

	/**
	 * Cycles through each word of input and translates each word to its Pig Latin
	 * equivalent.
	 * 
	 * @param input the sentence to translate
	 */
	private static void process(String input) {
		String[] sentence = input.split("\\s");
		String returnThis = "";
		for (String a : sentence) {
			if (a.substring(0, 1).matches("[AEIOU]"))
				returnThis += a + "YAY";
			else
				returnThis += a.substring(1) + a.charAt(0) + "AY";
			returnThis += " ";
		}
		System.out.println(returnThis.trim());
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr37.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(scan.nextLine());
		}
		scan.close();
	}
}
