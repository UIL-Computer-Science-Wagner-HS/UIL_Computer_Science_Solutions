import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
* @author Ian Fernandes
*/
public class Patterns {

	/**
	 * Determine if two patterns are the "same", with "same" being defined in the
	 * program specifications.
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	private static boolean process(String first, String second) {
		ArrayList<Character> firstList = new ArrayList<>();
		ArrayList<Character> secondList = new ArrayList<>();

		// Add unique chars to respective lists
		first.chars().mapToObj(x -> (char) x).forEach(y -> {
			if (!firstList.contains(y))
				firstList.add(y);
		});

		second.chars().mapToObj(x -> (char) x).forEach(y -> {
			if (!secondList.contains(y))
				secondList.add(y);
		});

		if (firstList.size() != secondList.size())
			return false;

		// Create mapping from letter of first to letter of second
		HashMap<Character, Character> charMap = new HashMap<>();
		for (int i = 0; i < firstList.size(); i++) {
			charMap.put(firstList.get(i), secondList.get(i));
		}

		// Map letters of first to letters of second
		for (int i = 0; i < first.length(); i++) {
			first = first.substring(0, i) + charMap.get(first.charAt(i)) + first.substring(i + 1);
		}

		return first.equals(second);
	}

	/**
	 * Handle input and process accordingly
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("patterns.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String first = scan.next(), second = scan.next();
			System.out.println(process(first, second) ? "YES" : "NO");
		}
		scan.close();
	}
}
