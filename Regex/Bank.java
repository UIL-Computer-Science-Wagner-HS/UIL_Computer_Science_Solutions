import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ian Fernandes
 *
 */
public class Bank {

	/**
	 * Extract all numbers from string.
	 * 
	 * @param input the string to extract numbers from
	 */
	private static void process(String input) {
		ArrayList<String> numbers = new ArrayList<>();
		Scanner sc = new Scanner(input);
		sc.useDelimiter("\\D+");	//skip over non-numbers
		while (sc.hasNext())
			numbers.add(sc.next());
		if (numbers.isEmpty()) {
			System.out.println("-\n0");
		} else {
			numbers.stream().mapToInt(x -> Integer.parseInt(x)).forEach(y -> System.out.print(y + " "));	//Print each one
			System.out.println("\n" + numbers.stream().mapToInt(x -> Integer.parseInt(x)).sum());			//Print sum
		}
		sc.close();
	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("bank.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0)
			process(scan.nextLine());
		scan.close();
	}
}
