import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Program #1 from 2017 UIL Invitational B Programming Contest
 * 
 * @author Ian Fernandes
 *
 */
public class Akio {

	/**
	 * Class to represent a cell in the two-dimensional maze
	 *
	 */
	static class RowCol {
		int row, col;
		RowCol parent;

		/**
		 * Construct a new RowCol object
		 * 
		 * @param r row index of cell
		 * @param c column index of cell
		 * @param p parent cell
		 */
		public RowCol(int r, int c, RowCol p) {
			row = r;
			col = c;
			parent = p;
		}
	}

	/**
	 * States if the spot at maze[r][c] already been visited
	 */
	private static boolean[][] visited = new boolean[10][10];

	/**
	 * 2D Maze to navigate
	 */
	private static char[][] maze = new char[10][10];

	/**
	 * Cells to visit (used in bfs)
	 */
	private static Queue<RowCol> toVisit = new LinkedList<>();

	/**
	 * Add these values to a given row index to cycle between North, East, South,
	 * and West
	 */
	private static int[] rowCycle = { -1, 0, 1, 0 };

	/**
	 * Add these values to a given column index to cycle between North, East, South,
	 * and West
	 */
	private static int[] colCycle = { 0, 1, 0, -1 };

	/**
	 * Perform the breadth-first search from the start position indicated.
	 * 
	 * Naturally determines shortest path from start to 'o' cell
	 * 
	 * @param start the cell to start from
	 * @return the target cell found or null if no path exists from start to
	 *         destination
	 */
	private static RowCol bfs(RowCol start) {
		toVisit.add(start);
		if (maze[start.row][start.col] == 'o') {
			return start;
		}

		while (!toVisit.isEmpty()) {
			RowCol current = toVisit.remove();
			visited[current.row][current.col] = true;

			if (maze[current.row][current.col] == 'o') {
				return current;
			}

			// Cycle through North, East, South, and West cells
			for (int i = 0; i < 4; i++) {
				int row = current.row + rowCycle[i];
				int col = current.col + colCycle[i];

				// If the given cell is valid, add it to the list of cells to search from.
				if (isGood(row, col)) {
					toVisit.add(new RowCol(row, col, current));
				}
			}
		}
		return null; // path not found
	}

	/**
	 * Is maze[row][col] valid (inside the array and open spot)
	 * 
	 * @param row the row index to check
	 * @param col the column index to check
	 * @return if the row-col combination is valid (and can therefore be visited by
	 *         bfs()
	 */
	private static boolean isGood(int row, int col) {
		return row >= 0 && row < 10 && col >= 0 && col < 10 && maze[row][col] != '#' && !visited[row][col];
	}

	/**
	 * Process input and handle according to program specifications.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("akio.dat"));
		Integer noCases = Integer.parseInt(scan.nextLine());

		// List of row-col pairs to start from for each maze
		ArrayList<RowCol> startPoints = new ArrayList<>();

		// Process each test case
		while (noCases-- > 0) {
			// Reset maze, visited array, and startPoints list
			maze = new char[10][10];
			visited = new boolean[10][10];
			startPoints.clear();

			// Construct 10 x 10 maze
			for (int rowNo = 0; rowNo < 10; rowNo++) {
				char[] currentRow = scan.nextLine().toCharArray();
				for (int c = 0; c < 10; c++) {
					char currentElement = currentRow[c];
					if (rowNo == 0 || rowNo == 9 || c == 0 || c == 9)
						if (currentElement == '.')
							startPoints.add(new RowCol(rowNo, c, null));
					maze[rowNo][c] = currentElement;
				}
			}

			// Ignore the '-' character after every test case, excluding the last one.
			if (noCases != 0)
				scan.nextLine();

			// Determine shortest path from any of the start points to the destination.
			int minPath = Integer.MAX_VALUE;

			// Go through each row-col start point and calculate shortest path. Update
			// minPath when necessary.
			nextIteration: for (RowCol current : startPoints) {
				visited = new boolean[10][10];
				toVisit.clear();

				// Get destination row-col cell returned by bfs
				RowCol dest = bfs(current);
				if (dest == null) {
					continue nextIteration;
				}

				// If dest is not null, find the path length
				int pathLength = 1;
				while (dest.parent != null) {
					pathLength++;
					dest = dest.parent;
				}

				// Update minPath if necessary
				if (pathLength < minPath)
					minPath = pathLength;
			}

			// Print out the shortest path
			System.out.println(minPath);
		}

		scan.close();

	}

}
