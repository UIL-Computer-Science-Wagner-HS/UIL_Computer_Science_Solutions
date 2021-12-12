import java.io.*;
import java.util.*;

public class Bishop {
	static int[][] moves = {{1,1},{1,-1},{-1,1},{-1,-1}};
	
	static void pop(int[][] arr){
		for(int i = 0; i<arr.length; i++)
			for(int j = 0; j<arr[0].length; j++)
				if(arr[i][j]==1)
					fill(arr,i,j);
		
		
	}
	static void fill(int[][] arr, int r, int c){
		for(int i = 0; i<4; i++){
			int row = r+moves[i][0];
			int col = c+moves[i][1];
			if(row>=0&&col>=0&&col<arr[0].length&&row<arr.length&&arr[row][col]==0){
				arr[row][col]=2;
				fill(arr,row,col);
				
			}
			
		}
		
		
	}
	static int countZs(int[][] arr){
		int ans = 0;
		for(int i = 0; i<arr.length; i++)
			for(int j = 0; j<arr[0].length; j++)
				if(arr[i][j]==0)
						ans++;
		return ans;
	}
	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("bishop.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int bishops = scan.nextInt();
			int[][] arr = new int[rows][cols];
			for (int i = 0; i < bishops; i++)
				arr[scan.nextInt()][scan.nextInt()] = 1;
			pop(arr);
			System.out.println(countZs(arr));

		}
	}
}
