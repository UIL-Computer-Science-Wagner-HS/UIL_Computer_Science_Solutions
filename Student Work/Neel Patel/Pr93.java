import java.io.*;
import java.util.*;
public class Pr93 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr93.dat"));
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
				if (arr[r][0] == '.') {
						x = r; y = 0;
						arr[x][y]='*';
						break;
					}
			}

			int count = steps(arr, visited, x, y);
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			System.out.println("PATH IS OF LENGTH " + count);
		}
	}

	 static int steps(char[][] arr, boolean[][] visited, int x, int y) {
		// TODO Auto-generated method stub
		 int step_counter = 1;
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
					 if (c == arr[0].length-1 && arr[r][c] == '.') {
						 step_counter++;
						 return step_counter; 
					 }
					 arr[r][c] = '*';
					 step_counter++;
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
				 }
			 }
		 }
		 
		 
		
		return 0;
	}

}
