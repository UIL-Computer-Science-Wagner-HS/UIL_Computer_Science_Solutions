import java.util.*;
import java.io.*;
import java.util.stream.*;

/**
 * @author Ian Fernandes
 *
 */
public class rectangle {
	
	private static char[][] arr;
	private static int strIndex;
	private static String str = "RECTANGLE";
	
	public static void constructRectangle(int level) {
		if (level >= arr.length/2.0) // At this point, everything will be filled in
			return;
		
		// Top row (left to right)
		for(int i = level; i<arr[level].length-level; i++)
			if(isSpotOpen(level, i))
				arr[level][i] = str.charAt(strIndex++%str.length());
		
		// Right column (top to bottom)
		for(int i = level+1; i<arr.length-level; i++)
			if(isSpotOpen(i, arr[level].length-1-level))
				arr[i][arr[level].length-1-level] = str.charAt(strIndex++%str.length());
		
		// Bottom row (right to left)
		for(int i = arr[level].length-2-level; i>=0; i--)
			if(isSpotOpen(arr.length-1-level, i))
				arr[arr.length-1-level][i] = str.charAt(strIndex++%str.length());
		
		// Left column (bottom to top)
		for(int i = arr.length-2-level; i>0; i--)
			if(isSpotOpen(i, level))
				arr[i][level] = str.charAt(strIndex++%str.length());
		
		constructRectangle(level+1);
	}
	
	public static boolean isSpotOpen(int row, int column) {
		return row>=0 && row<arr.length && column>=0 && column<arr[0].length && arr[row][column]==(char)0; // Within bounds and null char (don't overwrite)
	}
	
	public static void displayRectangle() {
		for(char[] row: arr) {
			IntStream.range(0, row.length).mapToObj(i -> row[i]).forEach(x -> System.out.print((char)x)); // Can't construct char stream from array the usual way (Arrays.stream())
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rectangle.dat"));
		while(scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split(",");
			arr = new char[Integer.parseInt(nextLine[1])][Integer.parseInt(nextLine[0])];
			strIndex = 0;
			constructRectangle(0);
			displayRectangle();
		}
	}
}
