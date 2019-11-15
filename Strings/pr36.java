package strings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class pr36 {

	/**
	 * Replace each character in the message with its cipher replacement to decode
	 * the message.
	 * 
	 * @param cipher  the cipher code to use
	 * @param message the message to decrypt with the cipher code
	 */
	private static void process(String cipher, String message) {
		ArrayList<Character> cipherCode = new ArrayList<>();
		cipher.chars().mapToObj(x -> (char) x).forEach(y -> cipherCode.add(y));

		StringBuilder sb = new StringBuilder(message);
		for (int i = 0; i < sb.length(); i++) {
			if(Character.isAlphabetic(sb.charAt(i)))
				sb.setCharAt(i, (char) (cipherCode.indexOf(sb.charAt(i)) + 65));
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr36.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String cipher = scan.nextLine();
			String message = scan.nextLine();
			process(cipher, message);
		}
		scan.close();
	}
}
