import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Ian Fernandes
 *
 */
public class Password {

	/**
	 * Solve password by finding the word in code string of length "length" that
	 * appears the most often.
	 * 
	 * @param code
	 * @param length
	 */
	private static void process(String code, int length) {
		// Create HashMap to map a string to its frequency in the code string
		HashMap<String, Integer> wordFrequency = new HashMap<>();
		for (int i = 0; i < code.length() - length + 1; i++) {
			String current = code.substring(i, i + length);
			if (wordFrequency.containsKey(current))
				wordFrequency.put(current, wordFrequency.get(current) + 1);
			else
				wordFrequency.put(current, 1);
		}

		// Find the word with the highest frequency
		String greatestFrequencyString = "";
		int greatestFrequency = Integer.MIN_VALUE;

		Set<String> it = wordFrequency.keySet();
		for (String key : it) {
			int frequency = wordFrequency.get(key);
			if (frequency > greatestFrequency) {
				greatestFrequency = frequency;
				greatestFrequencyString = key;
			}
		}

		System.out.println(greatestFrequencyString);
	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("password.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			String code = currentLine[0];
			int length = Integer.parseInt(currentLine[1]);
			process(code, length);
		}
		scan.close();
	}
}
