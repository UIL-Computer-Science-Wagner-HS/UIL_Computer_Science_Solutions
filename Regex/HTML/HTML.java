import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program #7 of 2015 UIL CS InvB Programming Contest
 * 
 * @author Ian Fernandes
 *
 */
public class HTML {

	/**
	 * Test if the HTML tags in the two strings are the same and arranged the same
	 * way (ignoring content of tag).
	 * 
	 * Method works by removing content of HTML tags (using Regex) and then
	 * comparing for equality.
	 * 
	 * @param first  the first HTML element
	 * @param second the second HTML element
	 * @return whether the two HTML elements are the same (according to program
	 *         specifications)
	 */
	private static boolean same(String first, String second) {
		first = first.replaceAll(">[\\w\\s]+<", "><");
		second = second.replaceAll(">[\\w\\s]+<", "><");
		return first.equals(second);
	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("html.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String first = scan.nextLine();
			String second = scan.nextLine();
			System.out.println(same(first, second) ? "same" : "different");
		}
		scan.close();
	}
}
