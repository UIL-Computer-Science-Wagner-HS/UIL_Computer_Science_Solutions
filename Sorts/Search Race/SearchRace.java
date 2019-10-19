import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * See problem description fore more information.
 * 
 * @author Ian Fernandes
 *
 */
public class SearchRace {

	/**
	 * Perform linear search and determine number of indices checked in the array
	 * 
	 * @param arr    the array to check
	 * @param target the value we are searching for
	 * @return the number of indices checked in arr while trying to find target
	 */
	private static int linSearch(int[] arr, int target) {
		int no = 0;
		for (int i = 0; i < arr.length; i++) {
			no++;
			if (arr[i] == target) {
				break;
			}
		}

		return no;
	}

	/**
	 * Perform binary search and determine number of indices checked in the array.
	 * 
	 * @param arr    the array to check
	 * @param target the value we are searching for
	 * @return the number of indices checked in arr while trying to find target
	 */
	private static int binSearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		int sum = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			sum++;
			if (arr[mid] == target)
				break;
			if (target < arr[mid])
				high = mid - 1;
			if (target > arr[mid])
				low = mid + 1;

		}
		return sum;
	}

	/**
	 * Scan in datasets and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("search_race.dat"));
		while (scan.hasNextLine()) {
			String[] targetArr = scan.next().split("\\)");
			int target = Integer.parseInt(targetArr[0].substring(1));
			String arr = scan.nextLine().replace(" ", "");
			arr = arr.substring(1, arr.length() - 1);
			String[] values = arr.split(",");
			int[] intArr = new int[values.length];
			for (int i = 0; i < values.length; i++) {
				intArr[i] = Integer.parseInt(values[i]);
			}

			int linSearch = linSearch(intArr, target);
			int binSearch = binSearch(intArr, target);

			System.out.println("B-" + binSearch + " / L-" + linSearch);
		}
		scan.close();

	}

}
