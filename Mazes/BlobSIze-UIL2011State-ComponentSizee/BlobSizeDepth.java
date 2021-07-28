import java.io.*;
import java.util.*;

public class BlobSizeDepth {
	
	static void rec(char[][] arr, int[][] ans,int r, int c){
		for(int j=0; j<8; j++){
			int x = r + moves[j][0];
			int y = c + moves[j][1];
			if(x>=0 && y>=0 && x<ans.length && y<ans[0].length && arr[x][y]=='*'
					&& ans[x][y]!=1){
				ans[x][y]=1;
				rec(arr,ans,x,y);
			}
		}
	}
	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },{ 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
//this counts number of *'s in blob using standard breadth first search
	// idea is to make an int[][] and make entries 1's if in the blob
	static int solve(char[][] arr, int r, int c){
		if(arr[r][c]=='.')
			return 0;
		else{
			int[][] ans = new int[arr.length][arr[0].length];
			
			ans[r][c]=1;
			rec(arr, ans,r,c);
					
					
					
					
					
				
							
			
			int sum = 0;
			for(int i = 0; i<ans.length; i++)
				for(int j = 0; j<ans[0].length; j++)
					if(ans[i][j]==1)
						sum++;
			
			return sum;
		}
		
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("blobsize.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			char[][] mat = new char[rows][cols];
			int trys = scan.nextInt();
			scan.nextLine();

			for (int i = 0; i < rows; i++)
				mat[i] = scan.next().toCharArray();
			while (trys-- > 0) {
				int r = scan.nextInt();
				int c = scan.nextInt();
				 int ans = solve(mat, r-1, c-1);
				 if (ans == 0)
					 System.out.println("NO BLOB");
				 else System.out.println(ans);

			}

		}

	}
}

class P2 {
	int row;
	int col;

	public P2(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

}