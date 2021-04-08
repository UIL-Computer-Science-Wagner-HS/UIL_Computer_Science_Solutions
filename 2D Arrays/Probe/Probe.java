import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.util.Pair;

public class Probe {
	
	static int[][] arr;
	
	static int getNumCrystals(int r, int c) {
		int sum = 0;
		for(int row = r-1; row<=r+1; row++)
			for(int col = c-1; col<=c+1; col++) {
				sum+=arr[row][col];
				arr[row][col] = 0;
			}
		return sum;
	}
	
	static ArrayList<Pair<Integer, Integer>> getAllPossiblePairsGiven(int row, int col) {
		ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
		for(int r = 1; r<arr.length-1; r++) {
			for(int c = 1; c<arr[r].length-1; c++) {
				pairs.add(new Pair<Integer, Integer>(r, c));
			}
		}
		return pairs;
	}
	
	static int[][] copy(int[][] arr) {
		int[][] temp = new int[arr.length][arr.length];
		for(int r = 0; r<arr.length; r++)
			for(int c = 0; c<arr.length; c++)
				temp[r][c] = arr[r][c];
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("probe.dat"));
		int numTestCases = Integer.parseInt(scan.nextLine());
		while(numTestCases-->0) {
			int sideLength = Integer.parseInt(scan.nextLine());
			arr = new int[sideLength][sideLength];
			for(int r = 0; r<sideLength; r++)
				for(int c = 0; c<sideLength; c++)
					arr[r][c] = scan.nextInt();
			scan.nextLine();
			int[][] copyArr = copy(arr);
			int maxNumCrystals = Integer.MIN_VALUE;
			for(int r = 1; r<arr.length-1; r++) {
				for(int c = 1; c<arr[r].length-1; c++) {
					arr = copy(copyArr);
					int firstNumCrystals = getNumCrystals(r, c);
					ArrayList<Pair<Integer, Integer>> otherPossiblePairs = getAllPossiblePairsGiven(r, c);
					int[][] nextCopy = copy(arr);
					for(Pair<Integer, Integer> pair: otherPossiblePairs) {
						arr = copy(nextCopy);
						int secondNumCrystals = getNumCrystals(pair.getKey(), pair.getValue());
						//System.out.printf("Number of crystals for 2: (%d, %d): %d%n", r, c, firstNumCrystals);
						int currNumCrystals = firstNumCrystals + secondNumCrystals;
						if(currNumCrystals>maxNumCrystals)
							maxNumCrystals = currNumCrystals;
					}
				}
			}
			System.out.println(maxNumCrystals);
		}
	}
}
