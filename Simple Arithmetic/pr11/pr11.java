package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr11 {

	private static void process(double gallons, double priceToday, double priceYesterday) {
		if (priceToday == priceYesterday) {
			System.out.print("PAID THE SAME");
			return;
		}

		boolean costMoreToday = priceToday > priceYesterday;
		if (costMoreToday)
			System.out.printf("PAID MORE: $%.2f", gallons * (priceToday - priceYesterday));
		else
			System.out.printf("SAVED: $%.2f", gallons * (priceYesterday - priceToday));
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr11.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			double gallons = Double.parseDouble(currentLine[0]);
			double priceToday = Double.parseDouble(currentLine[1]);
			double priceYesterday = Double.parseDouble(currentLine[2]);
			process(gallons, priceToday, priceYesterday);
			System.out.println();
		}
		scan.close();
	}
}
