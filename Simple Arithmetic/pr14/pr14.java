package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr14 {

	private static void process(int enrolled, int absent, int grade) {
		System.out.printf("%.1f%% PRESENT IN GRADE %d%n", (enrolled - absent) * 100.0 / enrolled, grade);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr14.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			int grade = 9;
			String[] currentLine = scan.nextLine().split(" ");
			for (int i = 0; i < currentLine.length - 1; i += 2)
				process(Integer.parseInt(currentLine[i]), Integer.parseInt(currentLine[i + 1]), grade++);
			System.out.println();
		}
		scan.close();
	}
}
