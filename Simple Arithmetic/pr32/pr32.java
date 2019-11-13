package strings;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class pr32 {

	private static void process(int input) {
		for (int i = 0; i <= input; i++) {
			if (i % 10 == 0)
				System.out.print(0);
			else if (i % 10 == 5)
				System.out.print(5);
			else
				System.out.print('-');
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr32.dat"));
		while (scan.hasNextLine())
			process(Integer.parseInt(scan.nextLine()));
		scan.close();

	}

}
