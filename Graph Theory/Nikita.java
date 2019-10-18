import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Nikita {

	/**
	 * I was kind of lazy, so I put everything in the main method :)
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//Set up new scanner for input
		Scanner scan = new Scanner(new File("nikita.dat"));
		while (scan.hasNextLine()) {
			//Construct connection matrix from input file
			int vertices = Integer.parseInt(scan.nextLine());
			int[][] connectionMatrix = new int[vertices][vertices];
			int longestPath = 0;
			for (int i = 0; i < vertices; i++) {
				String[] currentRow = scan.nextLine().split(" ");
				for (int j = 0; j < currentRow.length; j++) {
					connectionMatrix[i][j] = Integer.parseInt(currentRow[j]);
					if (Integer.parseInt(currentRow[j]) > longestPath)
						longestPath = Integer.parseInt(currentRow[j]);
				}
			}

			//Construct length tally matrix from connection matrix
			int[][] lengthTally = new int[connectionMatrix.length][longestPath];
			for (int r = 0; r < lengthTally.length; r++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int c = 0; c < connectionMatrix[r].length; c++) {
					if (!map.containsKey(connectionMatrix[r][c])) {
						map.put(connectionMatrix[r][c], 1);
					} else {
						map.put(connectionMatrix[r][c], map.get(connectionMatrix[r][c]) + 1);
					}
				}

				for (int c = 0; c < lengthTally.length; c++) {
					if (map.get(c + 1) != null)
						lengthTally[r][c] = map.get(c + 1);
				}
			}

			//Variables for keeping track of various statistics
			double leastDegree = Double.MAX_VALUE, highestDegree = Double.MIN_VALUE, leastCloseness = Double.MAX_VALUE,
					greatestCloseness = Double.MIN_VALUE;

			//Update variables accordingly
			for (int vertex = 0; vertex < lengthTally.length; vertex++) {
				double degree, closeness;
				degree = 1.0 * lengthTally[vertex][0] / (lengthTally.length - 1);
				int sum = 0;
				for (int connections = 0; connections < lengthTally[vertex].length; connections++) {
					sum += lengthTally[vertex][connections] * (connections + 1);
				}

				closeness = 1.0 * (lengthTally.length - 1) / sum;

				if (degree < leastDegree)
					leastDegree = degree;
				if (degree > highestDegree)
					highestDegree = degree;
				if (closeness < leastCloseness)
					leastCloseness = closeness;
				if (closeness > greatestCloseness)
					greatestCloseness = closeness;
			}

			//ArrayLists for storing vertices with the following characteristics: least degree, highest degree, least closeness, and greatest closeness
			ArrayList<Character> leastDegreeList = new ArrayList<>();
			ArrayList<Character> highestDegreeList = new ArrayList<>();
			ArrayList<Character> leastClosenessList = new ArrayList<>();
			ArrayList<Character> greatestClosenessList = new ArrayList<>();

			//Loop through each vertex and update lists accordingly
			for (int vertex = 0; vertex < lengthTally.length; vertex++) {
				double degree, closeness;
				degree = 1.0 * lengthTally[vertex][0] / (lengthTally.length - 1);
				int sum = 0;
				for (int connections = 0; connections < lengthTally[vertex].length; connections++) {
					sum += lengthTally[vertex][connections] * (connections + 1);
				}

				closeness = 1.0 * (lengthTally.length - 1) / sum;

				if (degree == leastDegree)
					leastDegreeList.add((char) ('A' + vertex));
				if (degree == highestDegree)
					highestDegreeList.add((char) ('A' + vertex));
				if (closeness == leastCloseness)
					leastClosenessList.add((char) ('A' + vertex));
				if (closeness == greatestCloseness)
					greatestClosenessList.add((char) ('A' + vertex));

			}

			//Print out results accordingly.
			System.out.printf("%-19s%.2f ", "least degree", leastDegree);
			for (Character a : leastDegreeList)
				System.out.print(a);
			System.out.println();

			System.out.printf("%-19s%.2f ", "greatest degree", highestDegree);
			for (Character a : highestDegreeList)
				System.out.print(a);
			System.out.println();

			System.out.printf("%-19s%.2f ", "least closeness", leastCloseness);
			for (Character a : leastClosenessList)
				System.out.print(a);
			System.out.println();

			System.out.printf("%-19s%.2f ", "greatest closeness", greatestCloseness);
			for (Character a : greatestClosenessList)
				System.out.print(a);
			System.out.println();
			System.out.println("---");

		}

		scan.close();

	}

}