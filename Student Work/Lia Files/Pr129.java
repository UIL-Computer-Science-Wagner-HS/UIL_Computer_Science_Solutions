import java.util.*;
import java.io.*;

public class Pr129 {
	public static int solve(char[][] maze, boolean[][] visited, int x, int y, String re, boolean hasAccess, int len)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, 0});
		visited[x][y] = true;
		String researcher = "ABCDEFGHIJ";
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && !visited[r][c] && maze[r][c] != '#')
				{
					if (maze[r][c] == 'Y')
					{
						return check[2]+1;
					}
					if (researcher.contains(Character.toString(maze[r][c])) && re.equals(""))
					{
						re = Character.toString(maze[r][c]);
						return solve(maze, new boolean[maze.length][maze[0].length], r, c, re, true, check[2]+1) + check[2]+1;
					}
					else if (Character.isAlphabetic(maze[r][c]))
					{
						if (Character.toString(maze[r][c]).equalsIgnoreCase(re) && hasAccess)
						{
							visited[check[0]][check[1]] = true;
							queue.add(new int[]{r, c, check[2]+1});
						}
						else
						{
							continue;
						}
					}
					else 
					{
						visited[check[0]][check[1]] = true;
						queue.add(new int[]{r, c, check[2]+1});
					}
				}
			}
		}
		return -len;
	}
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("pr129.dat"));
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
				for (int c = 0; c < maze[0].length; c++)
				{
					if (maze[r][c] == 'X')
					{
						startR = r;
						startC = c;
						break;
					}
				}
			}
			int ans = solve(maze, visited, startR, startC, "", false, 0);
			boolean possible = ans > 0;
			System.out.println(possible? ans + " seconds":"Impossible!");
		}
	}
}
