import java.io.*;
import java.util.*;

public class Mining {
	static boolean[][] visited;
	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int solve1(char[][] arr, int[] a) {
		for (int i = 0; i < 4; i++) {
			int row = a[0] + moves[i][0];
			int col = a[1] + moves[i][1];
			if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && !visited[row][col]
					&& arr[row][col] != 'O') {
				visited[row][col] = true;
				if(arr[row][col]=='C')
					return 1+solve1(arr,new int[] {row,col});
				return solve1(arr,new int[] {row,col});
			}
		
			}
		return 0;
	}
	static int solve(char[][] arr, int[] start) {
		//int steps = 0;
		visited[start[0]][start[1]] = true;
		int count = 0;
		Stack<int[]> stack = new Stack<>();
		stack.add(start);
		while (!stack.isEmpty()) {
			int[] a = stack.pop();
			//steps++;
			if (arr[a[0]][a[1]] == 'C')
				count++;
			for (int i = 0; i < 4; i++) {
				int row = a[0] + moves[i][0];
				int col = a[1] + moves[i][1];
				if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && !visited[row][col]
						&& arr[row][col] != 'O') {
					stack.push(new int[] { row, col });
					visited[row][col] = true;

				}

			}

		}
		//System.out.println(steps);
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("mining.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int startX = -1;
			int startY = -1;
			char[][] arr = new char[rows][cols];
			scan.nextLine();
			for (int i = 0; i < rows; i++)
				arr[i] = scan.nextLine().toCharArray();
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
					if (arr[i][j] == 'S') {
						startX = i;
						startY = j;

					}
			visited = new boolean[rows][cols];
			visited[startX][startY]=true;
			int ans = solve1(arr,new int[] {startX, startY});
			System.out.println(ans);

		}
	}

}

/*public boolean closeFar(int a, int b, int c) {
	  if(Math.abs(a-b)<=1&&Math.abs(b-c)>=2&&Math.abs(a-c)>=2)
	        return true;
	        
	  if(Math.abs(a-c)<=1&&Math.abs(b-c)>=2&&Math.abs(a-b)>=2)
	        return true;
	        
	  return false;            
	}*/
