package regex;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr19 {

	private static void process(String input) {
		//Variables to store the number of letters, digits, and other characters.
		int letters = 0, digits = 0, other = 0;
		for (int i = 0; i < input.length(); i++) {
			String currentChar = input.substring(i, i + 1);
			if (currentChar.matches("\\p{Alpha}"))	//Is letter?
				letters++;
			else if (currentChar.matches("\\d"))	//Is digit?
				digits++;
			else									//Other character
				other++;
		}
		System.out.printf("LETTERS:%3d DIGITS:%3d OTHER:%3d%n", letters, digits, other);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr19.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(scan.nextLine());
		}
		scan.close();
	}
}
