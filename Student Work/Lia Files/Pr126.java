import java.io.*;
import java.util.*;

public class Pr126 {
	
	// Creates mirror dimension char[][]
	public static char[][] mirror(char[][] maze, int rows, int cols)
	{
		char[][] mirror = new char[rows][cols];
		for (int r = 0; r < rows; r++)
		{
			int i = 0;
			for (int c = cols-1; c >= 0; c--)
			{
				mirror[r][i] = maze[r][c];
				i++;
			}
		}
		return mirror;
	}
	
	public static int solve(char[][] maze, boolean[][] visited, int x, int y)
	{
		int[][] moves = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
		Queue<int[]> queue = new LinkedList<>();
		
		/* check[3] = 0 -> Not in mirror dimension
		 * check[3] = 1 -> In mirror dimension
		 */
		queue.add(new int[] {x, y, 0, 0}); 
		
		visited[x][y] = true;
		
		// 'maze' and 'visited' array for the mirror dimension specifically
		boolean[][] mirrorVisited = new boolean[visited.length][visited[0].length];
		char[][] mirror = mirror(maze, maze.length, maze[0].length);
		
		while (!queue.isEmpty())
		{
			int[] check = queue.poll();
			
			//'Base case' if going into the mirror dimension finds the exit immediately
			if (mirror(maze, maze.length, maze[0].length)[check[0]][check[1]] == 'E') 
			{
				return check[2]+1;
			}
			for (int i = 0; i < 4; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length)
				{
					if (!visited[r][c] && maze[r][c] != '#')
					{
						if (check[3] == 1) // If entering normal maze from mirror dimension
						{
							check[3] = 0;
							check[2]++;
						}
						if (maze[r][c] == 'E')
						{
							return check[2]+1;
						}
						visited[r][c] = true;	
						queue.add(new int[] {r, c, check[2]+1, 0});
					}
					else if (!mirrorVisited[r][c] && mirror[r][c] != '.')
					{
						if (check[3] == 0) // If entering mirror dimension from normal maze
						{
							check[3] = 1;
							check[2]++;
						}
						if (mirror[r][c] == 'E')
						{
							return check[2]+1;
						}
						mirrorVisited[r][c] = true;	
						queue.add(new int[] {r, c, check[2]+1, 1});
					}
				}
			}	
		}
		return -1; // No exit found
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("pr126.dat"));
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
					if (maze[r][c] == 'S')
					{
						startR = r;
						startC = c;
						break;
					}
				}
			}
			/*for (char[] c: mirror(maze, rows, cols))
			{
				System.out.println(Arrays.toString(c));
			}
			System.out.println();
			*/
			System.out.println(solve(maze, visited, startR, startC));
		}
	}
}
