import java.io.*;
import java.util.*;

public class Pr95 {
	public static int countG (char[][] matrix, boolean[][] visited, int x, int y)
	{
		if (matrix[x][y] != 'G')
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
				if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && !visited[r][c] && matrix[r][c] == 'G')
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
		Scanner scan = new Scanner(new File("pr95.dat"));
		int rows = scan.nextInt();
		scan.nextLine();
		
		char[][] map = new char[rows][];
		for (int i = 0; i < rows; i++)
		{
			map[i] = scan.nextLine().toCharArray();
		}
		boolean[][] visited = new boolean[rows][map[0].length];
		
		int maxCount = 0;
		for (int r = 0; r < map .length; r++)
		{
			for (int c = 0; c < map[r].length; c++)
			{
				int count = countG(map, visited, r, c);
				if (count > maxCount)
				{
					maxCount = count;
				}
			}
		}
		System.out.println(maxCount);
		
		
	}
}
