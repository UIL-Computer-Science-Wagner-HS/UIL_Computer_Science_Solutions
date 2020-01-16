import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Problem #10 of 2017 UIL Invitational B Programming Contest
 * 
 * @author fernandesi2244
 *
 */
public class Pedro {

	private static List<String> powerSet = new ArrayList<>();
	private static String addThisBack = "";

	/**
	 * Calculate the power set for the options list.
	 * 
	 * @param options the list to find the power set of
	 */
	private static void findCombinations(List<String> options) {
		int n = options.size();
		for (int i = 1; i < (1 << n); i++) {
			String addString = "";
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					addString += options.get(j) + " ";
				}
			}
			powerSet.add(addString.trim());
			alphabetizeLastOne(); // Alphabetize within each element
		}
	}

	/**
	 * Pull off the last element added to the power set and sort within it.
	 */
	private static void alphabetizeLastOne() {
		String lastOne = powerSet.remove(powerSet.size() - 1);
		ArrayList<String> lastOneElements = new ArrayList<>();
		Scanner elementScanner = new Scanner(lastOne);
		while (elementScanner.hasNext()) {
			lastOneElements.add(elementScanner.next());
		}
		Collections.sort(lastOneElements);
		addThisBack = "";
		lastOneElements.forEach(x -> addThisBack += x + " ");
		addThisBack = addThisBack.trim();
		powerSet.add(addThisBack);
		elementScanner.close();
	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pedro.dat"));
		while (scan.hasNextLine()) {
			powerSet.clear();
			String[] nextLine = scan.nextLine().split(" ");
			int r = Integer.parseInt(nextLine[0]);
			List<String> options = new ArrayList<String>();
			for (int i = 1; i < nextLine.length; i++) {
				options.add(nextLine[i]);
			}

			findCombinations(options); // Find power set
			Collections.sort(powerSet); // Sort power set by first element

			// Print each element of the power set that has r items
			for (String current : powerSet) {
				if (current.split(" ").length == r)
					System.out.println(current);
			}

			System.out.println();
		}
		scan.close();
	}
}
