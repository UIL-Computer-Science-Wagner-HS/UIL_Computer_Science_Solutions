import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2019 A+ Computer Science - Packet 2 Problem #3
 * 
 * @author Ian Fernandes
 *
 */
public class floor_cleaner {

	/**
	 * Represents a specific point in the maze (2D Array)
	 *
	 */
	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static char[][] maze = new char[10][];
	static boolean[][] visited = new boolean[10][10];
	static Queue<Point> toVisit = new LinkedList<Point>();
	static int[] rowDir = { -1, 0, 1, 0 };
	static int[] colDir = { 0, 1, 0, -1 };
	static ArrayList<Character> obstacles = new ArrayList<>(Arrays.asList('W', 'F', 'O'));

	/**
	 * Perform BFS on maze to mark all spots that can be visited from base 'B'.
	 * 
	 * BFS is not required. DFS is also a viable solution.
	 * 
	 * @param startRow the row index to start bfs from
	 * @param startCol the column index to start bfs from
	 */
	private static void bfs(int startRow, int startCol) {
		toVisit.add(new Point(startRow, startCol));
		while (!toVisit.isEmpty()) {
			Point removed = toVisit.remove();
			visited[removed.row][removed.col] = true;
			for (int i = 0; i < 4; i++) {
				int newRow = removed.row + rowDir[i], newCol = removed.col + colDir[i];
				if (isValid(newRow, newCol) && !visited[newRow][newCol])
					toVisit.add(new Point(newRow, newCol));
			}
		}
	}

	/**
	 * Checks if the given row and column indices are valid and open spots.
	 * 
	 * @param row the row index to check
	 * @param col the column index to check
	 * @return if the spot in the maze at (row, col)
	 */
	private static boolean isValid(int row, int col) {
		return row >= 0 && row < maze.length && col >= 0 && col < maze[row].length
				&& !obstacles.contains(maze[row][col]);
	}

	/**
	 * Input data and process accordingly.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("floor_cleaner.dat"));
		int startRow = -1, startCol = -1;
		for (int i = 0; i < 10; i++) {
			maze[i] = scan.nextLine().toCharArray();
			for (int j = 0; j < maze[i].length; j++)
				if (maze[i][j] == 'B') {
					startRow = i;
					startCol = j;
				}
		}

		// Mark obstacles in maze with 'O'
		while (scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split(",");
			int column = Integer.parseInt(nextLine[0].replaceAll("[\\(]", ""));
			int row = Integer.parseInt(nextLine[1].replaceAll("[\\)]", ""));
			maze[row][column] = 'O';
		}

		// Run Breadth-first Search
		bfs(startRow, startCol);

		// Find all spots in the maze that weren't able to be accessed due to custom
		// obstacles.
		ArrayList<Point> unvisited = new ArrayList<>();
		for (int r = 0; r < visited.length; r++) {
			for (int c = 0; c < visited[r].length; c++) {
				if ((maze[r][c] == '-' || maze[r][c] == 'O') && !visited[r][c])
					unvisited.add(new Point(r, c));
			}
		}

		// Sort spots by row and then by column.
		unvisited.sort((a, b) -> {
			if (a.row != b.row)
				return a.row - b.row;
			return a.col - b.col;
		});

		// Print results.
		unvisited.forEach(x -> System.out.println("(" + x.col + "," + x.row + ")"));

		scan.close();

	}

}
