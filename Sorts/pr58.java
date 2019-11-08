package Sorting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class pr58 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr58.dat"));
		int no = Integer.parseInt(scan.nextLine());

		// ArrayList to hold input words
		ArrayList<String> list = new ArrayList<>();

		// Add each word in the input file to the ArrayList
		while (no-- > 0)
			list.add(scan.nextLine());

		// Sort words based on second and fourth letters
		list.sort((first, second) -> {
			if (!(first.charAt(1) == second.charAt(1)))
				return first.charAt(1) - second.charAt(1);
			return first.charAt(3) - second.charAt(3);
		});

		// Print each word from the sorted list on a new line
		list.forEach(x -> System.out.println(x));

		scan.close();
	}
}
