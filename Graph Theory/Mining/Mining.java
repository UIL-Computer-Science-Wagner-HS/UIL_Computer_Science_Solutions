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
public class Mining {

	private static char[][] cavern;
	private static int noCrystals;

	// Symbols that a miner cannot access. (+ is used to mark a cell visited)
	private static ArrayList<Character> closedSymbols = new ArrayList<>(Arrays.asList('O', '+'));

	/*
	 * The following arrays help to simplify accessing the northward, eastward,
	 * southward, and westward positions to a cell in the cavern matrix.
	 */
	private static int[] rowDirections = { -1, 0, 1, 0 };
	private static int[] colDirections = { 0, 1, 0, -1 };

	/**
	 * Depth first search that counts the number of crystals in the cavern matrix.
	 * 
	 * @param r the row of the element currently being looked at
	 * @param c the column of the element currently being looked at
	 */
	private static void dfs(int r, int c) {
		// If the cell contains a crystal, increment the noCrystals counter.
		if (cavern[r][c] == 'C')
			noCrystals++;

		// Mark the cell visited.
		cavern[r][c] = '+';

		// Cycle through all possible directions from a cell and continue dfs() from
		// "open" cells.
		for (int i = 0; i < 4; i++) {
			if (isOpen(r + rowDirections[i], c + colDirections[i])) {
				dfs(r + rowDirections[i], c + colDirections[i]);
			}
		}
	}

	/**
	 * Is cavern[r][c] valid (r and c within matrix) and not a closed spot (Already
	 * looked at or solid rock)?
	 * 
	 * @param r the row to check
	 * @param c the column to check
	 * @return boolean representing whether cavern[r][c] is "open"
	 */
	private static boolean isOpen(int r, int c) {
		return r >= 0 && r < cavern.length && c >= 0 && c < cavern[r].length && !closedSymbols.contains(cavern[r][c]);
	}

	/**
	 * Scan in arrays and process them with dfs().
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("mining.dat"));
		int no = Integer.parseInt(scan.nextLine());

		int startRow = -1, startCol = -1;

		while (no-- > 0) {
			noCrystals = 0;
			int row = Integer.parseInt(scan.next());
			int col = Integer.parseInt(scan.nextLine().trim());
			cavern = new char[row][col];
			for (int r = 0; r < row; r++) {
				char[] currentRow = scan.nextLine().toCharArray();
				for (int c = 0; c < currentRow.length; c++) {
					cavern[r][c] = currentRow[c];
					if (cavern[r][c] == 'S') {
						startRow = r;
						startCol = c;
					}
				}
			}

			dfs(startRow, startCol);
			System.out.println(noCrystals);
		}
		scan.close();
	}
}
