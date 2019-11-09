package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr12 {

	private static void process(String color, int length, int height, int windowsAndDoors) {
		int totalArea = length * height - windowsAndDoors;
		int gallons = (int) Math.ceil(totalArea / 300.0);
		System.out.println(color + " " + gallons + " GALLON (S)");
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr12.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			String color = currentLine[0];
			int length = Integer.parseInt(currentLine[1]);
			int height = Integer.parseInt(currentLine[2]);
			int windowsAndDoors = Integer.parseInt(currentLine[3]);
			process(color, length, height, windowsAndDoors);
		}
		scan.close();

	}

} 
