package strings;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class pr33 {

	private static void process(String input) {
		//You can know your data structures...
		LinkedHashSet<Character> chars = new LinkedHashSet<>(); // Use this instead of HashSet to maintain insertion order.
		input.chars().mapToObj(x -> (char) x).forEach(y -> chars.add(y));
		chars.forEach(x -> System.out.print(x));
		System.out.println();
		
		//Or just go full stream mode
		input.chars().mapToObj(x->(char)x).distinct().forEach(y->System.out.print(y));
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr33.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0)
			process(scan.nextLine().replace(" ", "")); // Spaces are ignored as per program instructions.
		scan.close();
	}
}
