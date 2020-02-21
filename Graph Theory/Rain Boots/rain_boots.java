import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2019 A+ Computer Science - PACKET 2, Problem #10 (Rain Boots)
 * 
 * @author Ian Fernandes
 */
public class rain_boots {

	static char[][] maze = new char[8][8];
	static Point[][] dijkstraArr = new Point[8][8];
	static int[] rowDir = { -1, 0, 1, 0 };
	static int[] colDir = { 0, 1, 0, -1 };

	static class Point {
		int muddyVal, leastMuddySoFar;
		boolean visited;

		public Point(int muddyVal) {
			this.muddyVal = muddyVal;
		}
	}

	static class Cell {
		int row, col;

		public Cell(int r, int c) {
			row = r;
			col = c;
		}
	}

	/**
	 * Run a modified dijkstra's algorithm on the maze
	 * 
	 * Directions: North, East, South, West
	 * 
	 * @param row row to start from
	 * @param col column to start from
	 */
	private static void dijkstra(int row, int col) {
		for (int i = 0; i < 4; i++) {
			int newRow = row + rowDir[i], newCol = col + colDir[i];
			if (isGoodSpot(newRow, newCol)) {
				if (!dijkstraArr[newRow][newCol].visited
						|| dijkstraArr[newRow][newCol].leastMuddySoFar > dijkstraArr[row][col].leastMuddySoFar
								+ dijkstraArr[newRow][newCol].muddyVal) {
					dijkstraArr[newRow][newCol].leastMuddySoFar = dijkstraArr[row][col].leastMuddySoFar
							+ dijkstraArr[newRow][newCol].muddyVal;
					dijkstraArr[row][col].visited = true;
					dijkstra(newRow, newCol);
				}
			}
		}
	}

	/**
	 * Are the row and column indices in bounds of the maze?
	 * 
	 * @param r the row index to check
	 * @param c the column index to check
	 * @return whether the given spot is open to be traversed
	 */
	private static boolean isGoodSpot(int r, int c) {
		return r >= 0 && r < 8 && c >= 0 && c < 8;
	}

	/**
	 * Process input accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rain_boots.dat"));
		int startRow = -1, startCol = -1, endRow = -1, endCol = -1;

		while (scan.hasNextLine()) {
			for (int r = 0; r < 8; r++)
				maze[r] = scan.nextLine().toCharArray();

			if (scan.hasNextLine())
				scan.nextLine();

			ArrayList<Cell> endPoints = new ArrayList<>();

			for (int r = 0; r < maze.length; r++) {
				for (int c = 0; c < maze[r].length; c++) {
					char current = maze[r][c];
					switch (current) {
					case 'M':
						dijkstraArr[r][c] = new Point(1);
						break;
					case '-':
						dijkstraArr[r][c] = new Point(0);
						break;
					case 'S':
						dijkstraArr[r][c] = new Point(0);
						startRow = r;
						startCol = c;
						break;
					case 'E':
						dijkstraArr[r][c] = new Point(0);
						dijkstraArr[r][c].leastMuddySoFar = Integer.MAX_VALUE;
						endPoints.add(new Cell(r, c));
					}
				}
			}

			dijkstra(startRow, startCol);

			// Check all the exits and find the minimum distance of those exits
			int minExitDistance = Integer.MAX_VALUE;
			for (Cell current : endPoints)
				if (dijkstraArr[current.row][current.col].leastMuddySoFar < minExitDistance)
					minExitDistance = dijkstraArr[current.row][current.col].leastMuddySoFar;
			System.out.println(minExitDistance);
		}

		scan.close();

	}

}
