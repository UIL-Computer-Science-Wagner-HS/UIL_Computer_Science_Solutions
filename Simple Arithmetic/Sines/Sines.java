import java.util.*;
import java.io.*;

public class Sines {

	/**
	 * Rearrange the law of sines to solve for B. Also remember to convert degrees
	 * into radians by multiplying by pi/180
	 * 
	 * @param A side A length
	 * @param a angle opposite side A
	 * @param b angle opposite side B
	 * @return length of side B
	 */
	private static double lawOfSines(int A, int a, int b) {
		return A * Math.sin(b * Math.PI / 180) / Math.sin(a * Math.PI / 180);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("sines.dat"));
		int no = Integer.parseInt(scan.nextLine());

		while (no-- > 0) {
			System.out.printf("%.1f%n", lawOfSines(scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}

		scan.close();
	}
}
