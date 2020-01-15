import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Program #5 from the 2017 Invitational B Programming Contest
 * 
 * @author fernandesi2244
 *
 */
public class Isidora {

	/**
	 * Process an input line and send its contents to the appropriate method.
	 * 
	 * @param input a line from the input file
	 */
	private static void process(String input) {
		String[] currentLine = input.split(" ");
		String[] operationSegment = currentLine[0].split("-");
		String operation = operationSegment[0];
		int no = Integer.parseInt(currentLine[1]);
		int operationNo = Integer.parseInt(operationSegment[1]);

		if (operation.equals("LS"))
			ls(no, operationNo);
		else if (operation.equals("RS"))
			rs(no, operationNo);
		else if (operation.equals("LC"))
			lc(no, operationNo);
		else
			rc(no, operationNo);
	}

	/**
	 * Method to implement left shift capability
	 * 
	 * @param no          the number to perform the left shift on
	 * @param operationNo the number to left shift by
	 */
	private static void ls(int no, int operationNo) {
		String result = Integer.toBinaryString(no << operationNo);
		System.out.println(result);
	}

	/**
	 * Method to implement right shift capability
	 * 
	 * @param no          the number to perform the right shift on
	 * @param operationNo the number to right shift by
	 */
	private static void rs(int no, int operationNo) {
		String result = Integer.toBinaryString(no >> operationNo);
		System.out.println(result);
	}

	/**
	 * Method to implement left circle capability.
	 * 
	 * Clever way to do this is by using Collections.rotate()
	 * 
	 * @param no          the number to perform the left circle on
	 * @param operationNo the number to left circle by
	 */
	private static void lc(int no, int operationNo) {
		ArrayList<Character> noList = new ArrayList<>();
		Integer.toBinaryString(no).chars().mapToObj(x -> (char) x).forEach(y -> noList.add(y));
		Collections.rotate(noList, -operationNo);
		noList.forEach(x -> System.out.print(x));
		System.out.println();
	}

	/**
	 * Method to implement right circle capability.
	 * 
	 * Clever way to do this is by using Collections.rotate()
	 * 
	 * @param no          the number to perform the right circle on
	 * @param operationNo the number to right circle by
	 */
	private static void rc(int no, int operationNo) {
		ArrayList<Character> noList = new ArrayList<>();
		Integer.toBinaryString(no).chars().mapToObj(x -> (char) x).forEach(y -> noList.add(y));
		Collections.rotate(noList, operationNo);
		noList.forEach(x -> System.out.print(x));
		System.out.println();
	}

	/**
	 * Process input file accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("isidora.dat"));
		while (scan.hasNextLine()) {
			process(scan.nextLine());
		}
		scan.close();

	}

}
