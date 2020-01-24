import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Santino {

	private static String[][] maze;

	private static Queue<Cell> toVisit;

	static class Cell {
		int r, c, pathLength;

		public Cell(int row, int col, int pathLength) {
			r = row;
			c = col;
			this.pathLength = pathLength;
		}
	}

	private static Cell bfs(int RS, int CS, int RE, int CE) {
		toVisit.add(new Cell(RS, CS, 0));

		while (!toVisit.isEmpty()) {
			Cell current = toVisit.remove();
			if (current.r == RE && current.c == CE) {
				return current;
			}

			// East
			if (maze[current.r][current.c].equals("E")) {
				for (int i = current.c + 1; i < maze[0].length; i++) {
					toVisit.add(new Cell(current.r, i, current.pathLength + 1));
				}
			}

			// West
			else if (maze[current.r][current.c].equals("W")) {
				for (int i = current.c - 1; i >= 0; i--) {
					toVisit.add(new Cell(current.r, i, current.pathLength + 1));
				}
			}

			// North
			else if (maze[current.r][current.c].equals("N")) {
				for (int i = current.r - 1; i >= 0; i--) {
					toVisit.add(new Cell(i, current.c, current.pathLength + 1));
				}
			}

			// South
			else if (maze[current.r][current.c].equals("S")) {
				for (int i = current.r + 1; i < maze.length; i++) {
					toVisit.add(new Cell(i, current.c, current.pathLength + 1));
				}
			}

			// North East
			else if (maze[current.r][current.c].equals("NE")) {
				for (int r = current.r - 1, c = current.c + 1; r >= 0 && c < maze[0].length; r--, c++) {
					toVisit.add(new Cell(r, c, current.pathLength + 1));
				}
			}

			// North West
			else if (maze[current.r][current.c].equals("NW")) {
				for (int r = current.r - 1, c = current.c - 1; r >= 0 && c >= 0; r--, c--) {
					toVisit.add(new Cell(r, c, current.pathLength + 1));
				}
			}

			// South East
			else if (maze[current.r][current.c].equals("SE")) {
				for (int r = current.r + 1, c = current.c + 1; r < maze.length && c < maze[0].length; r++, c++) {
					toVisit.add(new Cell(r, c, current.pathLength + 1));
				}
			}

			// South West
			else if (maze[current.r][current.c].equals("SW")) {
				for (int r = current.r + 1, c = current.c - 1; r < maze.length && c >= 0; r++, c--) {
					toVisit.add(new Cell(r, c, current.pathLength + 1));
				}
			}

		}

		return null;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("santino.dat"));
		int no = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < no; i++) {
			toVisit = new LinkedList<>();
			String[] info = scan.nextLine().split(" ");
			int rows = Integer.parseInt(info[0]);
			int RS = Integer.parseInt(info[2]);
			int CS = Integer.parseInt(info[3]);
			int RE = Integer.parseInt(info[4]);
			int CE = Integer.parseInt(info[5]);

			maze = new String[rows][];
			for (int j = 0; j < rows; j++) {
				maze[j] = scan.nextLine().split(" ");
			}

			Cell dest = bfs(RS, CS, RE, CE);
			if (dest == null) {
				System.out.printf("Case: #%d: Lost in the playground%n", i + 1);
			} else {
				System.out.printf("Case #%d: %d%n", i + 1, dest.pathLength);
			}
		}
		scan.close();
	}

}
