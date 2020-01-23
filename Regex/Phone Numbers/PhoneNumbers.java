import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PhoneNumbers {

	/**
	 * Return true if the phone number is valid (in the form ddd-ddd-dddd)
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isGood(String input) {
		return input.matches("\\d{3}-\\d{3}-\\d{4}");
	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("phoneNumbers.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String phoneNumber = scan.nextLine();
			System.out.println(isGood(phoneNumber) ? phoneNumber : "INVALID PHONE NUMBER");
		}
		scan.close();
	}
}
