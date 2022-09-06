import java.io.*;
import java.util.*;
public class Pr95 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("pr95.dat"));
		int r = scan.nextInt();
		scan.nextLine();
		//int c = scan.nextLine().length();
		char arr[][]= new char[r][];
		
			
			for (int i = 0; i < r; i++) {
				arr[i]= scan.nextLine().toCharArray();
			}
			boolean visited[][]= new boolean[r][arr[0].length];
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[0].length;col++) {
					System.out.print(arr[row][col]);
				}
				System.out.println();
			}
			int largest = solve(arr, visited, 0, 0);
			System.out.println(largest);
	}

	static int solve(char[][] arr, boolean[][] visited, int x, int y) {
		// TODO Auto-generated method stub
		int count_r = 0;
		int count_g = 0;
		int count_t = 0;
		
		int highest_r = 0;
		int highest_g = 0;
		int highest_t = 0;
		
		 int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		 Queue <int[]> line= new LinkedList<>();
		 line.add(new int[] {x,y});
		 visited[x][y]= true;
		 while(!line.isEmpty()) {
			 int [] check = line.poll();
			 for (int i = 0; i < 4; i++) {
				 boolean connected = false;
				 int r = check[0] + direction[i][0];
				 int c = check[1] + direction[i][1];
				 if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !visited[r][c] && arr[r][c] == 'R') {
					 count_r++;
					 connected = true;
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
				 }
				 if (connected == false) {
					 if(count_r  > highest_r)
						 highest_r = count_r;
					 count_r = 0;
				 }
			 }
			 for (int i = 0; i < 4; i++) {
				 boolean connected = false;
				 int r = check[0] + direction[i][0];
				 int c = check[1] + direction[i][1];
				 if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !visited[r][c] && arr[r][c] == 'G') {
					 count_g++;
					 connected = true;
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
				 }
				 if (connected == false) {
					 if (count_g > highest_g)
						 highest_g = count_g;
					 count_g = 0;
				 }
			 }
			 for (int i = 0; i < 4; i++) {
				 boolean connected = false;
				 int r = check[0] + direction[i][0];
				 int c = check[1] + direction[i][1];
				 if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !visited[r][c] && arr[r][c] == 'T') {
					 count_t++;
					 connected = true;
					 visited[r][c] = true;
					 line.add(new int[] {r,c});
				 }
				 if (connected == false) {
					 if (count_t > highest_t)
						 highest_t = count_t;
					 count_t = 0;
				 }
			 }

				 
		}
		 
		 if (highest_r > highest_g && highest_r > highest_t) {
			 return highest_r;
		 }
		 else if (highest_g > highest_r && highest_g > highest_t) {
			 return highest_g;
		 }
		 else {
			 return highest_t;
		 }
		 

	}





}