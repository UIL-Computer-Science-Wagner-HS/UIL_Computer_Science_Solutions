import java.util.*;
import java.io.*;

public class Pr125 {
	public static List<Integer> solve(char[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		List<Integer>  paths = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, 0});
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
						paths.add(check[2]+1);
					}
					else
					{
						visited[check[0]][check[1]] = true;
						queue.add(new int[] {r, c, check[2]+1});
					}
				}
			}
		}
		return paths;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr125.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0)
		{
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			scan.nextLine();
			
			char[][] maze = new char[rows][cols];
			boolean[][] visited = new boolean[rows][cols];
			
			for (int r = 0; r < rows; r++)
			{
				maze[r] = scan.nextLine().toCharArray();
			}
			
			int startR = 0;
			int startC = 0;
			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < cols; c++)
				{
					if (maze[r][c] == 'S')
					{
						startR = r;
						startC = c;
					}
				}
			}
			List<Integer> paths = solve(maze, visited, startR, startC);
			int count = 0;
			for (Integer i: paths)
			{
				if (i == paths.get(0))
				{
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
