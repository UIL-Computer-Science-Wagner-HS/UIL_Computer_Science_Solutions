import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * See problem picture for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Isabel {

	private LocalDate birthday;
	private String name;

	/**
	 * Each Isabel represents an entry in the input file.
	 * 
	 * @param name
	 * @param bday
	 */
	public Isabel(String name, LocalDate bday) {
		this.name = name;
		birthday = bday;
	}

	/**
	 * Returns the string in a form where it is all lower cased except for the first
	 * character of the string, which is capitalized.
	 * 
	 * Precondition: Assumes input contains at least one character.
	 * 
	 * @param input the string to edit
	 * @return the edited string
	 */
	public static String regularText(String input) {
		return input.charAt(0) + input.substring(1).toLowerCase();
	}

	/**
	 * Process entries from input file and sort them accordingly. Then, print out
	 * the sorted entries accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("isabel.dat"));
		ArrayList<Isabel> list = new ArrayList<>();

		while (scan.hasNextLine()) {
			String[] currentLine = scan.nextLine().split(" ");
			LocalDate temp = LocalDate.of(Integer.parseInt(currentLine[1]), Integer.parseInt(currentLine[2]),
					Integer.parseInt(currentLine[3]));
			list.add(new Isabel(currentLine[0], temp));
		}

		// Sort the list based on a custom Comparator
		Collections.sort(list, new Comparator<Isabel>() {
			public int compare(Isabel a, Isabel b) {
				// If a's day is less than b's day, return -1.
				if (a.birthday.getDayOfWeek().getValue() < b.birthday.getDayOfWeek().getValue())
					return -1;
				// If a's day is greater than b's day, return 1.
				if (a.birthday.getDayOfWeek().getValue() > b.birthday.getDayOfWeek().getValue())
					return 1;
				// Otherwise, the days are the same, so sort based on names.
				return a.name.compareTo(b.name);
			}
		});

		// Print each entry in the sorted list accordingly.
		for (Isabel entry : list) {
			System.out.printf("%-11s: %s, %s %d, %d%n", entry.name,
					regularText(entry.birthday.getDayOfWeek().toString()),
					regularText(entry.birthday.getMonth().toString()), entry.birthday.getDayOfMonth(),
					entry.birthday.getYear());
		}

		scan.close();
	}

}
