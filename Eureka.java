import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Eureka {

	/**
	 * Constructs a Random object with the given seed and uses its nextInt()
	 * function to get the next letter of the alphabet. Also keeps track of number
	 * of random letters "guessed" in order to achieve word.
	 * 
	 * @param seed the Random object's seed
	 * @param word the word to reconstruct
	 */
	private static void process(long seed, String word) {
		Random rand = new Random(seed);
		int sum = 0;
		while (word.length() != 0) {
			char c = (char) (rand.nextInt(26) + 65); // 26 letters in the alphabet starting at ASCII value 65 (A-Z)
			sum++;
			if (c == word.charAt(0))
				word = word.substring(1);
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("eureka.dat"));
		int no = Integer.parseInt(scan.nextLine());

		// Scan in each line as a seed/word pair and process each pair.
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			long seed = Long.parseLong(currentLine[0]);
			String word = currentLine[1];
			process(seed, word);
		}

		scan.close();

	}

}
