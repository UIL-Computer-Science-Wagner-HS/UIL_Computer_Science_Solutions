import java.util.*;
import java.io.*;

public class Gowri {

	private static void assembleGowri(int dimension) {
		char[][] gowriBoard = new char[dimension + 8][dimension + 8];
		for (int c = 4; c < 4+dimension; c++) {
			gowriBoard[0][c] = '*';
		}

		for (int c = 4; c < 4+dimension; c++) {
			gowriBoard[gowriBoard.length - 1][c] = '*';
		}
		
		int col = 3;
		for(int r = 1;r<4;r++) {
			gowriBoard[r][col] = '*';
			gowriBoard[r][gowriBoard[r].length-col-1] = '*';
			col--;
		}
		
		for(int r = 4;r<4+dimension;r++) {
			gowriBoard[r][0] = '*';
			gowriBoard[r][gowriBoard[r].length-1] = '*';
		}
		
		col = 1;
		for(int r = 4+dimension;r<gowriBoard.length-1;r++) {
			gowriBoard[r][col] = '*';
			gowriBoard[r][gowriBoard[r].length-col-1] = '*';
			col++;
		}

		printGowri(gowriBoard);
	}

	private static void printGowri(char[][] gowriBoard) {
		for (char[] a : gowriBoard) {
			for (char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
		
		System.out.println("--------------------");
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("gowri.dat"));
		int no = Integer.parseInt(scan.nextLine());

		while (no-- > 0) {
			assembleGowri(Integer.parseInt(scan.nextLine()));
		}

		scan.close();

	}

}
