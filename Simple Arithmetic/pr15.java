package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class pr15 {

	private static void process(int length, int width, int depth) {
		int cubicInches = length * width * depth;
		int gallons = (int) Math.round(1.0 * cubicInches / 231); // 231 is conversion factor (231 cubic inches in a gallon)
		System.out.println(gallons + " GALLONS");
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr15.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(scan.nextInt() * 12, scan.nextInt() * 12, scan.nextInt() * 12); // *12 from feet to inches
			try {
				scan.nextLine();
			} catch (NoSuchElementException e) {
			}
		}
		scan.close();
	}
}
