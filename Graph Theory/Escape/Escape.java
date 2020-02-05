import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2019 A+ Computer Science-Packet 3, #7 (Escape.java)
 * 
 * Implements a simple breadth-first algorithm to see if a path from the start
 * cell to the destination cell exists. A basic depth-first approach is not
 * viable in this case due to the possibility of matrices in the input file with
 * row and column counts up to 10,000!
 * 
 * @author Ian Fernandes
 *
 */
public class Escape {

	static char[][] maze;
	static boolean[][] visited;
	static Queue<Point> toVisit = new LinkedList<>();
	static int destRow, destCol;
	static int[] rowDir = { -1, 0, 1, 0 };
	static int[] colDir = { 0, 1, 0, -1 };

	static class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static boolean bfs(int startRow, int startCol) {
		toVisit.add(new Point(startRow, startCol));

		while (!toVisit.isEmpty()) {
			Point current = toVisit.remove();
			int currentRow = current.row, currentCol = current.col;
			visited[currentRow][currentCol] = true;
			if (currentRow == destRow && currentCol == destCol)
				return true;
			for (int i = 0; i < 4; i++) {
				int newRow = current.row + rowDir[i], newCol = current.col + colDir[i];
				if (openSpot(newRow, newCol) && !visited[newRow][newCol])
					toVisit.add(new Point(newRow, newCol));
			}
		}
		return false;
	}

	private static boolean openSpot(int row, int col) {
		return row >= 0 && row < maze.length && col >= 0 && col < maze[row].length && maze[row][col] == '.';
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("escape.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			String[] dimensions = scan.nextLine().split(" ");
			int rows = Integer.parseInt(dimensions[0]);
			int columns = Integer.parseInt(dimensions[1]);

			maze = new char[rows][columns];
			visited = new boolean[rows][columns];
			toVisit.clear();

			for (int i = 0; i < rows; i++)
				maze[i] = scan.nextLine().toCharArray();

			String coordinates[] = scan.nextLine().split(" ");
			int startRow = Integer.parseInt(coordinates[0]);
			int startCol = Integer.parseInt(coordinates[1]);
			destRow = Integer.parseInt(coordinates[2]);
			destCol = Integer.parseInt(coordinates[3]);

			System.out.println(bfs(startRow, startCol) ? "Escaped" : "Trapped");
		}
		scan.close();

	}

}
