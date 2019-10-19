import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class Klara {
	// char[][] to represent character grid
	private static char[][] maze;

	// list of closed symbols (that should not be accessible during a dfs traversal)
	private static ArrayList<Character> closedSymbols;

	/**
	 * Depth first search marks all cells accessible from char[r][c] recursively.
	 * 
	 * @param r the row index to start search from
	 * @param c the column index to start search from
	 */
	private static void dfs(int r, int c) {
		if (!open(r, c))
			return;
		maze[r][c] = '-';

		dfs(r - 1, c); // North
		dfs(r, c + 1); // East
		dfs(r + 1, c); // South
		dfs(r, c - 1); // West
	}

	/**
	 * Is the spot at maze[r][c] open (accessible)?
	 * 
	 * @param r the row index to check
	 * @param c the column index to check
	 * @return boolean whether maze[r][c] is valid and open
	 */
	private static boolean open(int r, int c) {
		return r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && !closedSymbols.contains(maze[r][c]);
	}

	/**
	 * Prints the contents of the maze array
	 */
	private static void printArr() {
		for (char[] a : maze) {
			for (char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}

	/**
	 * Scan in data and manipulate according to problem statement.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Scanner for input
		Scanner scan = new Scanner(new File("klara.dat"));
		while (scan.hasNextLine()) {

			// Reset the closedSymbols list
			closedSymbols = new ArrayList<>(Arrays.asList('-'));
			int dimensions = Integer.parseInt(scan.nextLine());
			maze = new char[dimensions][dimensions];

			// Fill in array properly
			for (int i = 0; i < dimensions; i++) {
				char[] nextLine = scan.nextLine().toCharArray();
				for (int j = 0; j < nextLine.length; j++) {
					maze[i][j] = nextLine[j];
				}
			}

			// Add the "opposite" of the middle element in the maze to the closedSymbols
			// list.
			closedSymbols.add(maze[dimensions / 2][dimensions / 2] == '.' ? '#' : '.');

			// Start the dfs traversal from the middle element.
			dfs(dimensions / 2, dimensions / 2);
			
			//Print the results of the dfs
			printArr();
			System.out.println("=====");
		}

		scan.close();
	}
}
