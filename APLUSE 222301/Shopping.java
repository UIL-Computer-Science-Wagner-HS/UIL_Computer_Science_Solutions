import java.io.*;
import java.util.*;

public class Shopping {
	static int[][] moves = {{1,0},{-1,0},{0,-1},{0,1}};
	static boolean solve(char[] targets, char[][] maze, int x, int y) {
		int[][] visited = new int[maze.length][maze[0].length];
		List<Character> tars=new ArrayList<>();
		for(char c: targets)
			tars.add(c);
		Queue<int[]> queue = new LinkedList<>();
		int[] check = {x,y};
		queue.add(check);
		while(!queue.isEmpty()) {
			check = queue.poll();
			for(int i = 0; i<4; i++) {
			int row = check[0]+moves[i][0];
			int col= check[1]+moves[i][1];
			if(row>0 && col>=0&&row<maze.length&&col<maze[0].length&&visited[row][col]<targets.length&&maze[row][col]!='#') {
				visited[row][col]++;
				if(tars.contains(maze[row][col])) {
					tars.remove((Character)maze[row][col]);
					if(tars.size()==0)
						return true;
				}
				queue.add(new int[] {row,col});
				
			}
			
			}
			
		}
		
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner scan = new Scanner(new File("shopping.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String[] arr = scan.nextLine().split(",");
			int rows = Integer.parseInt(arr[0]);
			int cols = Integer.parseInt(arr[1]);
			int items = Integer.parseInt(arr[2]);
			char[][] maze = new char[rows][cols];
			for (int i = 0; i < rows; i++)
				maze[i] = scan.nextLine().toCharArray();
			char[] targets = new char[items];
			for (int i = 0; i < 3; i++) {
				targets[i] = scan.nextLine().charAt(0);
			}
			// find entry
			int x = 0;
			int y = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < rows; j++)
					if (maze[i][j] == 'e') {
						x = i;
						y = j;
						break;

					}

			}
			boolean ans = solve(targets, maze, x,y);
			System.out.println(ans?"It's grocery time!": "It's not grocery time, sorry champ.");

		}

	}

}
