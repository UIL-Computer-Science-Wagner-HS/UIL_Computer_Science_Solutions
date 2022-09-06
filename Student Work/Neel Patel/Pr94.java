import java.io.*;
import java.util.*;
public class Pr94 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr94.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		while (n-- > 0) {
			int row = scan.nextInt();
			int col = scan.nextInt();
			scan.nextLine();
			int x = 0; int y = 0;
			char arr[][]= new char[row][col];
			boolean visited[][]= new boolean[row][col];
			for (int i = 0; i < arr.length; i++) {
				arr[i]= scan.nextLine().toCharArray();
			}
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					if (arr[r][c] == 'S') {
						x = r; y = c;
						break;
					}
				}
			}
			boolean solvable = solve(arr, visited, x, y);
			System.out.println(solvable? "EXIT FOUND!": "NO EXIT FOUND!");
		}
	}

	 static boolean solve(char[][] arr, boolean[][] visited, int x, int y) {
		 int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		 Queue <int[]> line= new LinkedList<>();
		 line.add(new int[] {x,y});
		 visited[x][y]= true;
		 while(!line.isEmpty()) {
			 int [] check = line.poll();
			 for (int i = 0; i < 4; i++) {
				 int r = check[0] + direction[i][0];
				 int c = check[1] + direction[i][1];
				 if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !visited[r][c]&& arr[r][c] != 'X') {
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
					 if (arr[r][c]=='E')
						 return true;
					 if (arr[r][c]== 'J') {
							 if ((c+2) < arr[r].length && arr[r][c+2]=='.') {
								 visited[r][c+2] = true;
								 line.add(new int[] {r,c+2});
							 }
							 if ((c-2) >= 0 && arr[r][c-2]=='.') {
								 visited[r][c-2] = true;
								 line.add(new int[] {r,c-2});
							 }
							 if ((r+2) < arr.length && arr[r+2][c]=='.') {
								 visited[r+2][c] = true;
								 line.add(new int[] {r+2,c});
							 }
							 if ((r-2) >= 0 && arr[r-2][c]=='.') {
								 visited[r-2][c] = true;
								 line.add(new int[] {r-2,c});
							 }
					 }

				 }
			 }
		 }
		 
		return false;
	}

}