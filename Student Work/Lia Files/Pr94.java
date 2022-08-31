import java.io.*;
import java.util.*;

public class Pr94 {
	public static boolean solve(char[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		int[][] jumpMoves = { {2, 0}, {-2, 0}, {0, 2}, {0, -2} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				if (maze[check[0]][check[1]] == 'J')
				{
					int r = check[0] + jumpMoves[i][0];
					int c = check[1] + jumpMoves[i][1];
					if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c] && maze[r][c] != 'X')
					{
						if (maze[r][c] == 'E')
						{
							return true;
						}
						visited[r][c] = true;	
						queue.add(new int[] {r, c});
					}
				}
				
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c] && maze[r][c] != 'X')
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
		Scanner scan = new Scanner(new File("pr94.dat"));
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
			
			for (int r = 0; r < maze.length; r++)
			{
				for (int c = 0; c < maze[0].length; c++)
				{
					if (maze[r][c] == 'S')
					{
						boolean ans = solve(maze, visited, r, c);
						System.out.println(ans? "EXIT FOUND!" : "NO EXIT FOUND!");
						break;
					}
				}
			}
		}
	}
}
