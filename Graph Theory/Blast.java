import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Blast {
	static char[][] maze = new char[10][10];
	static Cell[][] dijkstraArr = new Cell[10][10];
	static int[] rowDir = { -1, 0, 1, 0 };
	static int[] colDir = { 0, 1, 0, -1 };

	static int startRow = -1, startCol = -1, endRow = -1, endCol = -1;

	static class Cell {
		int energyVal, minEnergyToCell;

		public Cell(int energyVal) {
			this.energyVal = energyVal;
		}
	}

	private static void dijkstra(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int newRow = r + rowDir[i], newCol = c + colDir[i];
			if (goodSpot(newRow, newCol)) {
				if (dijkstraArr[newRow][newCol].minEnergyToCell == 0
						|| dijkstraArr[newRow][newCol].minEnergyToCell > dijkstraArr[r][c].minEnergyToCell
								+ dijkstraArr[newRow][newCol].energyVal) {
					dijkstraArr[newRow][newCol].minEnergyToCell = dijkstraArr[r][c].minEnergyToCell
							+ dijkstraArr[newRow][newCol].energyVal;

					dijkstra(newRow, newCol);
				}
			}
		}
	}

	private static boolean goodSpot(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 10 && dijkstraArr[r][c].energyVal > 0;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("blast.dat"));
		for (int r = 0; r < 10; r++)
			maze[r] = scan.nextLine().toCharArray();
		int maxEnergy = Integer.parseInt(scan.nextLine());

		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				char current = maze[r][c];
				switch (current) {
				case 'X':
					dijkstraArr[r][c] = new Cell(-1);
					break;
				case '*':
					dijkstraArr[r][c] = new Cell(5);
					break;
				case '.':
					dijkstraArr[r][c] = new Cell(1);
					break;
				case 'S':
					dijkstraArr[r][c] = new Cell(0);
					startRow = r;
					startCol = c;
					break;
				case 'E':
					dijkstraArr[r][c] = new Cell(1);
					dijkstraArr[r][c].minEnergyToCell = Integer.MAX_VALUE;
					endRow = r;
					endCol = c;
				}
			}
		}

		dijkstra(startRow, startCol);

		System.out.println(dijkstraArr[endRow][endCol].minEnergyToCell <= maxEnergy ? "Escaped!" : "Impossible");

		scan.close();

	}

}
