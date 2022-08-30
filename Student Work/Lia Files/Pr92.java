import java.util.*;
import java.io.*;

public class Pr92 {
	public static boolean solve(char[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c] && maze[r][c] != '#')
				{
					if (maze[r][c] == 'E')
					{
						return true;
					}
					visited[r][c] = true;	
					queue.add(new int[] {r, c});
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr92.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0)
		{
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			scan.nextLine();
			
			char[][] maze = new char[rows][cols];
			boolean[][] visited = new boolean[rows][cols];
			
			for (int i = 0; i < rows; i++)
			{
				maze[i] = scan.nextLine().toCharArray();
			}
			
			boolean ans = solve(maze, visited, 0, 0);
			System.out.println(ans?"EXIT FOUND" : "NO EXIT");
		}
	}
}
