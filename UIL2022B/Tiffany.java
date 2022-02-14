import java.io.*;
import java.util.*;

public class Tiffany {
	static boolean isSquare(int[][] arr, int row, int col, int adder){
		for(int i = row; i<row+adder+1; i++)
			for(int j = col; j<col+adder+1; j++)
				if(arr[row][col]!=arr[i][j])
					return false;
		return true;	
	}
	static int solve(int[][] arr, int row, int col){
		int ans = 0;
		int adder = 0;
		while(row+adder<arr.length&&col+adder<arr[0].length){
		if(isSquare(arr, row, col, adder)){
			ans++;
			adder++;
		}
		else break;
		}
		return ans;
	}
	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("tiffany.dat"));
		int noSets = scan.nextInt();
		int count = 1;
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int[][] arr = new int[rows][cols];
			for(int i = 0; i<rows; i++)
				for(int j = 0; j<cols; j++)
					arr[i][j]= scan.nextInt();
			int squares = 0;
			for(int i = 0; i<rows; i++)
				for(int j = 0; j<cols; j++)
					squares+=solve(arr,i,j);
			System.out.println("Case #"+count++ +": "+squares);		
			
			
	}
}
}