import java.io.*;
import java.util.*;

public class Pr124 {
	public static int solve(String[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, 0});
		visited[x][y] = true;
		int length = 0;
		
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c])
				{
					if (maze[r][c].equals("E"))
					{
						return check[2]+1;
					}
					if (maze[check[0]][check[1]].equals("S") || Integer.parseInt(maze[r][c]) <= Integer.parseInt(maze[check[0]][check[1]]))
					{
						visited[r][c] = true;
						queue.add(new int[] {r, c, check[2]+1});
						length = check[2];
					}
				}
			}
		}
		return length; 
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr124.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0)
		{
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			scan.nextLine();
			
			boolean[][] visited = new boolean[rows][cols];
			
			String[][] maze = new String[rows][cols];
			for (int r = 0; r < rows; r++)
			{
				maze[r] = scan.nextLine().split("[ ]+");
			}
			
			int startR = 0;
			int startC = 0;
			for (int r = 0; r < maze.length; r++)
			{
				for (int c = 0; c < maze[0].length; c++)
				{
					if (maze[r][c].equals("S"))
					{
						startR = r;
						startC = c;
						break;
					}
				}
			}
			int ans = solve(maze, visited, startR, startC);
			System.out.println(ans);

		}
	}
}
