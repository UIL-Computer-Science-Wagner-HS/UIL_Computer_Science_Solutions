import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tiffany {
	static int[][] canvas;
	
	static int getNumOfChromaticSquares() {
		int numChromaticSquares = 0;
		int maxSideLength = Math.min(canvas.length, canvas[0].length);
		for(int currSideLength = 1; currSideLength<=maxSideLength; currSideLength++)
			for(int r = 0; r<=canvas.length-currSideLength; r++)
				for(int c = 0; c<=canvas[r].length-currSideLength; c++)
					if(allSameColor(r, c, currSideLength))
						numChromaticSquares++;
		return numChromaticSquares;
	}
	
	static boolean allSameColor(int row, int col, int sideLength) {
		Set<Integer> colors = new HashSet<>();
		for(int r = row; r<row+sideLength; r++)
			for(int c = col; c<col+sideLength; c++)
				colors.add(canvas[r][c]);
		return colors.size()==1;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("tiffany.dat"));
		int num = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<num; i++) {
			String[] nextLine = scan.nextLine().split("\\s+");
			int numRows = Integer.parseInt(nextLine[0]);
			int numCols = Integer.parseInt(nextLine[1]);
			canvas = new int[numRows][numCols];
			for(int r = 0; r<numRows; r++)
				for(int c = 0; c<numCols; c++)
					canvas[r][c] = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Case #"+(i+1)+": "+getNumOfChromaticSquares());
		}
	}
}
