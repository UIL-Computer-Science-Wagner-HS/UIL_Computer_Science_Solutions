package Sorting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class pr57 {

	private String firstName, middleName, lastName;

	/**
	 * Represents a student
	 * 
	 * @param first
	 * @param middle
	 * @param last
	 */
	public pr57(String first, String middle, String last) {
		firstName = first;
		middleName = middle;
		lastName = last;
	}

	/**
	 * Gotta love those one-liners!
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr57.dat"));
		int no = Integer.parseInt(scan.nextLine());

		ArrayList<pr57> students = new ArrayList<>();

		// Scan in each student and add to an ArrayList appropriately depending on
		// whether there is a middle name.
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			students.add(currentLine.length == 2 ? new pr57(currentLine[0], "", currentLine[1])
					: new pr57(currentLine[0], currentLine[1], currentLine[2]));
		}

		// Sort the list by last name
		students.sort((first, second) -> first.lastName.compareTo(second.lastName));

		// Print each student according to the output specifications
		for (pr57 current : students)
			System.out.println(current.lastName + ", " + current.firstName + " "
					+ (current.middleName.isEmpty() ? "" : current.middleName + " "));

		scan.close();
	}
}
