/**
 * 
 */
package region2018;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Debra.java | Input: debra.dat | UIL Region 2018
 * 
 * @author Ian Fernandes
 *
 */
public class Debra {

	/**
	 * Takes an ArrayList of Strings and prints out each row in reversed order.
	 * 
	 * @param rows ArrayList of rows
	 */
	public static void printReverse(ArrayList<String> rows) {

		// Loop through each row in the ArrayList
		rows.forEach(row -> {
			// Print the reversed version of a row by using a StringBuilder object
			System.out.println(new StringBuilder(row).reverse().toString());
		});

		System.out.println("=====");
	}

	/**
	 * Takes input two-dimensional arrays and prints out their mirror image
	 * (horizontally) to the console. The first line of the input contains the # of
	 * rows followed by the # of columns. The (row) lines following that contain the
	 * contents of each row of the two-dimensional array.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// Construct a scanner to scan the input file.
		Scanner scan = new Scanner(new File("debra.dat"));

		// Scan through each test case of the input file.
		while (scan.hasNextLine()) {

			// Scan in the first line of the input test case to determine the number of
			// rows.
			String size = scan.nextLine();
			int r = Integer.parseInt(size.split(" ")[0]);

			// Construct an ArrayList to hold each row as a String
			ArrayList<String> rows = new ArrayList<>();

			// Loop through all the rows of the two-dimensional array
			for (int row = 0; row < r; row++) {
				rows.add(scan.nextLine());
			}

			// Send ArrayList to helper method to print the reverse of each row.
			printReverse(rows);

		}
		scan.close();

	}

}
