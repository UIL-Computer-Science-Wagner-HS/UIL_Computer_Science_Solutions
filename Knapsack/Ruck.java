package uil2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ruck {

	static double solve(double[] probs, int[] weights, double max, int index) {
		if (max <= 0)
			return 1;
		if (index == probs.length)
			return -1000;

		double use = solve(probs, weights, max - weights[index], index + 1) * probs[index];
		
		double noUse = solve(probs, weights, max, index + 1);
		return Math.max(use, noUse);

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ruck.dat"));
		int noSets = scan.nextInt();
		int casN =1;
		while (noSets-- > 0) {
			int n = scan.nextInt();
			int max = scan.nextInt();
			double[] probs = new double[n];
			int[] vals = new int[n];
			for (int i=0; i<n; i++) {
				vals[i] = (scan.nextInt());
				probs[i] = 1-scan.nextDouble()/100;
			}
			double ans = solve(probs, vals, max, 0);
			System.out.printf("Case #%d:  %.6f\n", casN++,100-ans*100);
			}
		}

	}

