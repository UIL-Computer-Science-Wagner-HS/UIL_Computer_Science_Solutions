package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr18 {

	private static void process(int input) {
		System.out.println("ROUNDING IS FUN");
		for (int i = 1; i <= input; i++) {
			double squareRoot = Math.sqrt(i);
			double cubeRoot = Math.cbrt(i);
			System.out.printf("%3d%6.1f%8.2f%n", i, squareRoot, cubeRoot);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr18.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(Integer.parseInt(scan.nextLine()));
			System.out.println();
		}
		scan.close();
	}
}
