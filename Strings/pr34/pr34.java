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
public class pr34 {

	/**
	 * Switch the first and second letters, thirds and fourth letters, etc. UNLESS
	 * the input length is odd: Switch the second and third letters, fourth and
	 * fifth letters, etc. Then, move the first letter to the end of the string.
	 * 
	 * @param input the string to unscramble
	 */
	private static void process(String input) {
		String newString = "";
		for (int i = input.length() % 2 == 0 ? 0 : 1; i < input.length() - 1; i += 2) {
			newString += "" + input.charAt(i + 1) + input.charAt(i);
		}
		if (input.length() % 2 != 0)
			newString += input.charAt(0);

		System.out.println(newString);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr34.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (scan.hasNextLine())
			process(scan.nextLine());

		scan.close();
	}
}
