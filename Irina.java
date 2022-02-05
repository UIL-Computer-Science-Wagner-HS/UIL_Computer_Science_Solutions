import java.io.*;
import java.util.*;

public class Irina {
	int weight;
	String name;

	// these objects are used for printing the ordered results
	public Irina(int weight, String name) {
		super();
		this.weight = weight;
		this.name = name;
	}

	// value per weight
	static Map<String, Double> map = new HashMap<>();
	static {
		map.put("PENNIES", 2.5);
		map.put("NICKELS", 5 / 5.0);
		map.put("DIMES", 10 / 2.25);
		map.put("QUARTERS", 25 / 5.0);
		map.put("DOLLARS", 100 / 2.5);

	}
	// to be used in final printing for ordering
	static Map<String, Integer> map2 = new HashMap<>();
	static {
		map2.put("PENNIES", 1);
		map2.put("NICKELS", 2);
		map2.put("DIMES", 3);
		map2.put("QUARTERS", 4);
		map2.put("DOLLARS", 5);

	}

	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("irina.dat"));

		int noSets = scan.nextInt();

		while (noSets-- > 0) {
			int n = scan.nextInt();
			String[] bags = new String[n];
			int[] weights = new int[n];
			double[] prices = new double[n];
			// here is the array used for dynamic programming
			double[][] arr = new double[n + 1][46];
			// input for each
			for (int i = 0; i < n; i++) {
				int bagWeight = scan.nextInt();
				String str = scan.next();

				bags[i] = str;
				weights[i] = bagWeight;
				prices[i] = bagWeight * map.get(str);
			}
			// fill the array }
			for (int r = 1; r < arr.length; r++)
				for (int c = 1; c < 46; c++) {
					if (weights[r - 1] <= c) {
						arr[r][c] = Math.max(arr[r - 1][c], prices[r - 1] + arr[r - 1][(c - weights[r - 1])]);

					} else
						arr[r][c] = arr[r - 1][c];
				}
			// now to print the results
			// list holds the items selected to max value
			List<Irina> list = new ArrayList<>();
			// we back track to find items used
			int row = arr.length - 1;
			int col = arr[0].length - 1;
			int sum = 45;
			while (row > 0 && sum > 0) {

				if (arr[row][col] != arr[row - 1][col]) {
					list.add(new Irina(weights[row - 1], bags[row - 1]));
					sum += weights[row - 1];
					col = col - weights[row - 1];
					row--;
				} else
					row--;

			}
			// now to sort everything
			Comparator<Irina> comp1 = (a, b) -> b.weight - a.weight;
			Comparator<Irina> comp2 = (a, b) -> map2.get(b) - map2.get(a);
			list.sort(comp1.thenComparing(comp2));
			list.forEach(a -> System.out.println("GRAB THE " + a.weight + " KG BAG OF " + a.name));
			System.out.println();

		}
	}
}
