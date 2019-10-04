import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Ian Fernandes
 */
public class Romero {

	/**
	 * Print header to match output format.
	 */
	private static void printHeader() {
		System.out.printf("%-19s%-11s%-11s%-6s%-6s%-7s%s|%n", "Date", "Attendance", "Gross", "ATP", "STP", "Adults",
				"Stu/Child");
	}

	/**
	 * Use Cramer's Rule to solve the system of equations and determine the number
	 * of adults and students that attended the game. Then, print the results
	 * accordingly.
	 * 
	 * @param dateArray
	 * @param noTickets
	 * @param amountCollected
	 * @param adultRate
	 * @param studentRate
	 */
	private static void process(String[] dateArray, int noTickets, double amountCollected, double adultRate,
			double studentRate) {
		// Set up date formatter
		LocalDate date = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[0]),
				Integer.parseInt(dateArray[1]));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY");

		// Cramer's Rule
		double d = studentRate - adultRate;
		int x = (int) ((noTickets * studentRate - amountCollected) / d); // no of adults
		int y = (int) ((amountCollected - adultRate * noTickets) / d); // no of students

		// Print results accordingly
		System.out.printf("%-19s%-11d$%,-10.2f$%-5.2f$%-5.2f%-7d%-9d|%n", formatter.format(date), noTickets,
				amountCollected, adultRate, studentRate, x, y);
	}

	/**
	 * Scan in data sets and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("romero.dat"));
		int no = Integer.parseInt(scan.nextLine());
		printHeader();

		while (no-- > 0) {
			String[] date = scan.next().split("/");
			int noTickets = Integer.parseInt(scan.next());
			double amountCollected = Double.parseDouble(scan.next());
			double adultRate = Double.parseDouble(scan.next());
			double studentRate = Double.parseDouble(scan.next());
			process(date, noTickets, amountCollected, adultRate, studentRate);
		}
		scan.close();
	}
}
