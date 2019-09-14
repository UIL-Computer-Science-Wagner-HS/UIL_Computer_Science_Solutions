import java.util.*;
import java.io.*;

public class Steganography {

	private static String process(String input) {
		String returnThis = "";

		for (int i = 0; i < input.length(); i+=2) {
			returnThis += input.charAt(i);
		}

		return returnThis;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("steganography.dat"));
		int no = Integer.parseInt(scan.nextLine());

		while (no-- > 0) {
			System.out.println(process(scan.nextLine()));
		}

		scan.close();

	}

}
