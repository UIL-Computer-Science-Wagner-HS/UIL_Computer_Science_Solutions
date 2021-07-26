
import java.io.*;
import java.util.*;

public class BlobTop {
	static int moves[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int[][] find(char[][] arr, int r, int c) {
		int row = r;
		int col = c;
		int[][] mat = new int[arr.length][arr[0].length];
		mat[r][c] = 1;
		Queue<Poi> queue = new LinkedList();
		queue.add(new Poi(r, c));
		while (!queue.isEmpty()) {
			Poi check = queue.poll();
			for (int j = 0; j < 4; j++) {
				int testX = check.x + moves[j][0];
				int testY = check.y + moves[j][1];
				//System.out.println("x "+testX+" y "+testY);
				if (testX >= 0 && testY >= 0 && testX < arr.length && testY < arr[0].length && mat[testX][testY] != 1
						&& arr[testX][testY] == '*') {
					mat[testX][testY]= 1;
					queue.add(new Poi(testX,testY));

				}

			}

		}
		return mat;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("blob.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			//scan.nextLine();
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int cases = scan.nextInt();
			scan.nextLine();
			char[][] arr = new char[rows][cols];
			for (int i = 0; i < rows; i++)
				arr[i] = scan.nextLine().toCharArray();
			for (int i = 0; i < cases; i++) {
				int r = scan.nextInt();
				int c = scan.nextInt();
				if (arr[r-1][c-1] == '.')
					System.out.println("Not a blob");
				else {
					int[][] ans = new int[rows][cols];
					ans = find(arr, r-1, c-1);
					Lab:
					for(int i1 = 0; i1<ans.length; i1++)
						for(int j1 = 0; j1<ans[0].length; j1++)
							if(ans[i1][j1]==1){
								System.out.println((i1+1)+" "+(j1+1));
								break Lab;
							}
				}

			}

		}

	}
}

class Poi {
	int x;
	int y;

	public Poi(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}