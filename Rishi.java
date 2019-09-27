import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rishi {

	/**
	 * Decompresses the input string by turning number/letter pairs into a string
	 * consisting solely of letters.
	 * 
	 * @param input compressed string
	 * @return decompressed string
	 */
	private static String decompress(String input) {
		String returnThis = "";

		// Look for one or more digits followed by a letter
		Pattern p = Pattern.compile("(\\d+)(\\p{Alpha})");
		Matcher m = p.matcher(input);

		// While there are more matches in the input string
		while (m.find()) {
			int no = Integer.parseInt(m.group(1)); // Number to repeat
			char c = m.group(2).charAt(0); // Character to repeat

			for (int i = 0; i < no; i++)
				returnThis += c;
		}

		return returnThis;
	}

	/**
	 * Compresses the input string by turning a string consisting solely of letters
	 * to number/letter pairs.
	 * 
	 * @param input decompressed string
	 * @return compressed string
	 */
	private static String compress(String input) {
		String returnThis = "";
		char currentLetter = input.charAt(0);
		int currentCount = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != currentLetter) {
				returnThis += "" + currentCount + currentLetter;
				currentLetter = input.charAt(i);
				currentCount = 1;
			} else
				currentCount++;
		}

		// Need this because for the last letter that repeats, the loop will stop, so
		// input.charAt(i)!=currentLetter won't be
		// evaluated.
		returnThis += "" + currentCount + currentLetter;

		return returnThis;
	}

	/**
	 * Scan in from input file and process each line accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rishi.dat"));
		while (scan.hasNextLine()) {
			String nextLine = scan.nextLine();
			if (Character.isDigit(nextLine.charAt(0)))
				System.out.println(decompress(nextLine));
			else
				System.out.println(compress(nextLine));
		}
		scan.close();
	}
}
