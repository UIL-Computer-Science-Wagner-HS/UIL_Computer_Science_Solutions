package strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr31 {

	private static void process(String input) {
		char firstLetter = input.charAt(0);
		int sum = 0;
		for (int i = 0; i < input.length(); i++)
			if (input.charAt(i) == firstLetter)
				sum++;
		System.out.println(firstLetter + ": " + sum);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr31.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(scan.nextLine());
		}
		scan.close();
	}
}
