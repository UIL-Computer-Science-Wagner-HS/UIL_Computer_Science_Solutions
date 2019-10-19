import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class LongestRun {

	/**
	 * Process input string to find longest sequence that matches given parameters
	 * of target and tolerance.
	 * 
	 * @param input a line in the input file.
	 */
	private static void process(String input) {
		//Parse input string to separate different data.
		String[] splitted = input.split("\\)");
		String[] runValues = splitted[0].substring(1).split(",");
		String[] tt = splitted[1].substring(1).split(",");
		System.out.println(Arrays.toString(tt));

		int target = Integer.parseInt(tt[0]);
		int tolerance = Integer.parseInt(tt[1]);

		//Make copy array of String[] to represent int[]
		int[] ints = new int[runValues.length];
		for (int i = 0; i < runValues.length; i++) {
			ints[i] = Integer.parseInt(runValues[i]);
		}
		System.out.println(Arrays.toString(ints));
		int max = 1;

		//Run through  ints array looking for longest sequence that matches parameters.
		for (int i = 0; i < ints.length; i++) {
//System.out.println(i);
			int start = i, sum = 1;
			while (Math.abs(ints[start] - target) <= tolerance) {
				sum++;
				start++;
				if (start == ints.length)
					break;
			}
			if (sum > max)
				max = sum;
		}

		//If the path is (in actuality) less than two steps, then no path has been found.
		if (max == 2)
			System.out.println("No Run");
		else
			System.out.println("Run Length - " + (max-1)); //Else, print longest path
	}

	/**
	 * Scan in input data and process it accordingly.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("longest_run.dat"));
		while (scan.hasNextLine()) {
			process(scan.nextLine());
		}
		scan.close();

	}
}
