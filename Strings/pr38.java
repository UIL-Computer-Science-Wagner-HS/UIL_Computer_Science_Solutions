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
public class pr38 {

	/**
	 * Cycles through the alphabet from char letter for length letters. If 'Z' is
	 * printed and there are still more letters to print, cycle back to 'A'.
	 * 
	 * @param letter the character to start with
	 * @param length the length of the alphabet to cover
	 */
	private static void printAlphabet(char letter, int length) {
		for (int i = 0; i < length; i++) {
			if ((char) (letter - 1) == 'Z')
				letter = 'A';
			System.out.print((char) (letter++));
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr38.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			char letter = scan.next().charAt(0);
			int length = Integer.parseInt(scan.next());
			printAlphabet(letter, length);
		}
		scan.close();

	}

}
