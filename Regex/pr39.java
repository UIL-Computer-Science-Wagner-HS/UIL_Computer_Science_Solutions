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
public class pr39 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr39.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			// Remove all characters that are non-alphabetic and non-space.
			System.out.println(scan.nextLine().replaceAll("[^\\p{Alpha}\\s]", ""));
			// ^ is applied distributively to the or operation of the two character classes.
		}
		scan.close();
	}
}
