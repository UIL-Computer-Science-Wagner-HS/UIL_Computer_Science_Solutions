import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Botan {

	private static boolean isBotanPrime(int no) {
		if (no < 10) {
			return isPrime(no);
		}

		ArrayList<String> substrings = getSubstrings(no);
		for (String current : substrings) {
			int currentNo = Integer.parseInt(current);
			if (currentNo != no && !isPrime(currentNo))
				return false;
		}
		return true;
	}

	private static boolean isPrime(int no) {
		if (no == 1)
			return false;
		if (no == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(no); i++) {
			if (no % i == 0)
				return false;
		}
		return true;
	}

	private static ArrayList<String> getSubstrings(int no) {
		String noString = Integer.toString(no);
		ArrayList<String> returnThis = new ArrayList<String>();
		for (int i = 0; i < noString.length(); i++) {
			for (int j = i; j < noString.length(); j++) {
				returnThis.add(noString.substring(i, j + 1));
			}
		}

		return returnThis;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("botan.dat"));
		int noCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < noCases; i++) {
			int current = Integer.parseInt(scan.nextLine());
			if (isBotanPrime(current)) {
				System.out.println("Case #" + (i + 1) + ": BOTAN-PRIME");
			} else {
				System.out.println("Case #" + (i + 1) + ": NOT BOTAN-PRIME");
			}
		}
		scan.close();

	}

}
