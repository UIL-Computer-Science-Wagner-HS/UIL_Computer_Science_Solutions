import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Displacement {

	/**
	 * Scan in data and process accordingly.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("displacement.dat"));
		
		//Scan in x-y coordinate
		String coordinateString = scan.nextLine();
		String[] coordinateArr = coordinateString.substring(1, coordinateString.length() - 1).split(",");
		double x = Double.parseDouble(coordinateArr[0]);
		double y = Double.parseDouble(coordinateArr[1]);

		//Make duplicate variables for calculating the distance later.
		double xOriginal = x, yOriginal = y;

		//While there are more travel instructions, process them accordingly.
		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split("/");
			double radians = Math.toRadians(Double.parseDouble(line[0]));
			double distance = Double.parseDouble(line[1]);
			x += Math.cos(radians) * distance;
			y += Math.sin(radians) * distance;
		}

		// Even though the program name is Displacement, the problem instructions
		// consistently mention to find the distance, not displacement.
		double displacement = Math.abs(Math.sqrt(Math.pow((x - xOriginal), 2) + Math.pow(y - yOriginal, 2)));

		//Print result rounded to two decimal places.
		System.out.printf("%.2f", displacement);
		scan.close();
	}

}
