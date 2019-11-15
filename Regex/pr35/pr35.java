package strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 */
public class pr35 {

	/**
	 * Remove all multi-line comments in the input string.
	 * 
	 * @param input the string to remove multi-line comments from
	 */
	private static String removeComments(String input) {
		input = input.replaceAll("/\\*.*\\*/", "");
		return input;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr35.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			System.out.println(removeComments(scan.nextLine()));
		}
		scan.close();
	}
}
