package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr16 {

	private static double newValue(double input) {
		if (input > 100)
			return input * .9;
		return input * 1.1; //Adding 5 to this does not result in output specified by sample output.
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr16.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			System.out.printf("$%.2f%n", newValue(Double.parseDouble(scan.nextLine())));
		}
		scan.close();
	}
}
