package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr13 {

	private static void process(String operator, int first, int second) {
		System.out.print(first + " " + operator + " " + second + " = ");
		switch (operator) {
		case "+":
			System.out.println(first + second);
			break;
		case "-":
			System.out.println(first - second);
			break;
		case "*":
			System.out.println(first * second);
			break;
		case "/":
			System.out.printf("%.1f%n", 1.0 * first / second);
			break;
		case "\\":
			System.out.println(first / second);
			break;
		case "%":
			System.out.println(first % second);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr13.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			String operator = currentLine[0];
			int first = Integer.parseInt(currentLine[1]);
			int second = Integer.parseInt(currentLine[2]);
			process(operator, first, second);
		}
		scan.close();
	}
}
