import java.io.*;
import java.util.*;
public class Pr92 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr92.dat"));
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
			System.out.println(solvable? "EXIT FOUND": "NO EXIT");
		}
	}

	 static boolean solve(char[][] arr, boolean[][] visited, int x, int y) {
		// TODO Auto-generated method stub
		 int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		 Queue <int[]> line= new LinkedList<>();
		 line.add(new int[] {x,y});
		 visited[x][y]= true;
		 while(!line.isEmpty()) {
			 int [] check = line.poll();
			 for (int i = 0; i < 4; i++) {
				 int r = check[0] + direction[i][0];
				 int c = check[1] + direction[i][1];
				 if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !visited[r][c]&& arr[r][c] != '#') {
					 if (arr[r][c]=='E')
						 return true;
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
				 }
			 }
		 }
		 
		 
		
		return false;
	}

}
