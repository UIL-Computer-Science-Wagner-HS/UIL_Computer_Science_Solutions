import java.util.*;
import java.io.*;

public class Pr93 {
	public static int solve(char[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		maze[x][y] = '*';
		
		int length = 1;
		
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c] && maze[r][c] != '#')
				{
					visited[r][c] = true;	
					maze[r][c] = '*';
					queue.add(new int[] {r, c});
					length++;
					break;
				}
			}
		}
		
		return length;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr93.dat"));
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
			
			int startR = 0;
			int startC = 0;
			for (int r = 0; r < maze.length; r++)
			{
				if (maze[r][0] == '.')
				{
					startR = r;
					break;
				}
			}
			
			int ans = solve(maze, visited, startR, startC);
			for (char[] c: maze)
			{
				System.out.println(c);
			}
			System.out.println("PATH IS OF LENGTH " + ans);
			System.out.println();
		}
	}
}
