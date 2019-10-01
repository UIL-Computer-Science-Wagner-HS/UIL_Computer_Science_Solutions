import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Max {

	/**
	 * HashMap to represent NATO Phonetic Alphabet. The keys are "regular"
	 * alphanumeric characters, and the values are NATO phonetic alphabet
	 * characters.
	 */
	private static final HashMap<Character, String> NATO = new HashMap<>();

	/**
	 * Initialize the NATO HashMap with proper keys and values. (This runs when the
	 * class is loaded)
	 */
	static {
		NATO.put('A', "Alpha");
		NATO.put('B', "Bravo");
		NATO.put('C', "Charlie");
		NATO.put('D', "Delta");
		NATO.put('E', "Echo");
		NATO.put('F', "Foxtrot");
		NATO.put('G', "Golf");
		NATO.put('H', "Hotel");
		NATO.put('I', "India");
		NATO.put('J', "Juliet");
		NATO.put('K', "Kilo");
		NATO.put('L', "Lima");
		NATO.put('M', "Mike");
		NATO.put('N', "November");
		NATO.put('O', "Oscar");
		NATO.put('P', "Papa");
		NATO.put('Q', "Quebec");
		NATO.put('R', "Romeo");
		NATO.put('S', "Sierra");
		NATO.put('T', "Tango");
		NATO.put('U', "Uniform");
		NATO.put('V', "Victor");
		NATO.put('W', "Whiskey");
		NATO.put('X', "Xray");
		NATO.put('Y', "Yankee");
		NATO.put('Z', "Zulu");
		NATO.put('0', "Zero");
		NATO.put('1', "Wun");
		NATO.put('2', "Too");
		NATO.put('3', "Tree");
		NATO.put('4', "Fower");
		NATO.put('5', "Fife");
		NATO.put('6', "Six");
		NATO.put('7', "Seven");
		NATO.put('8', "Ait");
		NATO.put('9', "Niner");
	}

	/**
	 * Process each character by retrieving its value from the NATO HashMap and
	 * printing it.
	 * 
	 * @param input
	 */
	private static void process(String input) {
		input.chars().mapToObj(x -> (char) x).forEach(y -> System.out.print(NATO.get(y) + " "));
		System.out.println();
	}

	/**
	 * Scan in each line from the input and process it accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("max.dat"));
		while (scan.hasNextLine())
			process(scan.nextLine());
		scan.close();
	}
}
