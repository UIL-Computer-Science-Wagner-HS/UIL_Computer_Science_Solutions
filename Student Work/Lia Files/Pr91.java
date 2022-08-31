import java.util.*;
import java.io.*;

public class Pr91 {
	public static int count$ (char[][] matrix, boolean[][] visited, int x, int y)
	{
		if (matrix[x][y] != '$')
		{
			return 0;
		}
		
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		int count = 1;
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !visited[r][c] && matrix[r][c] == '$')
				{
					count++;
					visited[r][c] = true;	
					queue.add(new int[] {r, c});
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr91.dat"));
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		scan.nextLine();
		
		char[][] matrix = new char[rows][cols];
		boolean[][] visited = new boolean[rows][cols];
		
		for (int i = 0; i < rows; i++)
		{
			matrix[i] = scan.nextLine().toCharArray();
		}
		
		int maxCount = 0;
		for (int r = 0; r < matrix.length; r++)
		{
			for (int c = 0; c < matrix[r].length; c++)
			{
				int count = count$(matrix, visited, r, c);
				if (count > maxCount)
				{
					maxCount = count;
				}
			}
		}
		System.out.println("Biggest group of $s is " + maxCount + ".");
	}
}
