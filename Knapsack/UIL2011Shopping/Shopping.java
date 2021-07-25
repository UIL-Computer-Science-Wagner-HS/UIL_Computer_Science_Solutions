import java.io.*;
import java.util.*;

public class Shopping {
	static double findMax(double[] arr, double limit, int index) {
		if (limit < 0)
			return -1000;
		if (index == arr.length)
			return 0;

		double use = findMax(arr, limit - arr[index], index + 1) + arr[index];
		double notUse = findMax(arr, limit, index + 1);
		return Math.max(use, notUse);

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("shopping.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] strs = scan.nextLine().split(" ");
			int len = strs.length;
			double[] arr = new double[len];
			for (int i = 0; i < len; i++)
				arr[i] = Double.parseDouble(strs[i]);
			double max = findMax(arr, 200, 0);
			System.out.printf("%.2f\n",200-max);

		}

	}
}
