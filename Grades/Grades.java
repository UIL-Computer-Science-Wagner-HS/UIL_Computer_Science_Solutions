import java.util.*;
import java.io.*;

public class Grades {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new File("grades.dat"));
		int n = Integer.parseInt(scan.nextLine());

		while (n-- > 0) {

			String firstName = scan.next(), lastName = scan.next();
			double sum = 0;

			for (int i = 0; i < 6; i++) {
				sum += scan.nextInt();
			}

			System.out.printf("%s, %s %.2f", lastName, firstName, sum / 6);

			System.out.println();
		}
		
		scan.close();

	}

}
