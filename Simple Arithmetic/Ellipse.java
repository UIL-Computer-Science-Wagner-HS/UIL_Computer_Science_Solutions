import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Ellipse {

	public static void main(String[] args) throws IOException {
		// Set up scanner and continue to loop while there are more lines in the input
		// file to scan.
		Scanner scan = new Scanner(new File("ellipse.dat"));
		while (scan.hasNextLine()) {
			// Scan in the two values a and b.
			double a = Double.parseDouble(scan.next());
			double b = Double.parseDouble(scan.next());

			// Calculate the area and the perimeter of the current ellipse.
			double area = Math.PI * a * b;
			double perimeter = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);

			// Print results accordingly.
			System.out.printf("(area - %.3f) (perimeter - %.3f)%n", area, perimeter);
		}

		scan.close();
	}
}
