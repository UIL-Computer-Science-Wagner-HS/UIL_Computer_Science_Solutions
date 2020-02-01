import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019 A+ Computer Science Packet 3: Problem #7
 * 
 * @author Ian Fernandes
 *
 */
public class Escape {

	private static char[][] maze;
	private static int rowDest, colDest;
	private static ArrayList<Character> closedSymbols = new ArrayList<>(Arrays.asList('#', '+', 'x'));

	/**
	 * Perform depth-first search to see if path exists from cell at (rowStart,
	 * colStart) to (rowDest, colDest)
	 * 
	 * @param row the row index currently being examined
	 * @param col the column index currently being examined
	 * @return whether there is a path from the start cell to the destination cell
	 */
	private static boolean dfs(int row, int col) {
		if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
			return false;
		}
		if (closedSymbols.contains(maze[row][col])) {
			return false;
		}

		if ((row == rowDest) && (col == colDest)) {
			return true;
		}

		maze[row][col] = '+';

		if (dfs(row - 1, col))
			return true;
		if (dfs(row, col + 1))
			return true;
		if (dfs(row + 1, col))
			return true;
		if (dfs(row, col - 1))
			return true;

		maze[row][col] = 'x';
		return false;

	}

	/**
	 * Handle input and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("escape.dat"));
		int noDataSets = Integer.parseInt(scan.nextLine());
		while (noDataSets-- > 0) {
			String[] rowColArr = scan.nextLine().split(" ");
			int row = Integer.parseInt(rowColArr[0]);
			maze = new char[row][];

			// Construct maze
			for (int r = 0; r < row; r++) {
				maze[r] = scan.nextLine().toCharArray();
			}

			// Find destination cell
			String destBegArr[] = scan.nextLine().split(" ");
			rowDest = Integer.parseInt(destBegArr[0]);
			colDest = Integer.parseInt(destBegArr[1]);

			int rowStart = Integer.parseInt(destBegArr[2]);
			int colStart = Integer.parseInt(destBegArr[3]);

			// Print results according to dfs() implementation
			System.out.println(dfs(rowStart, colStart) ? "Escaped" : "Trapped");
		}
		scan.close();

	}

}
