import java.util.*;
import java.io.*;

public class Maze {
	
	private static char[][] maze;
	private static Queue<Point> queue = new LinkedList<>();
	private static ArrayList<Character> closedSymbols = new ArrayList<>(Arrays.asList('#', '+'));
	
	static class Point {
		int row, col;
		Point parent;
		
		public Point(int row, int col, Point parent) {
			this.row = row;
			this.col = col;
			this.parent = parent;
		}
	}
	
	private static Point find(int row, int col) {
		queue.add(new Point(row, col, null));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(maze[p.row][p.col]=='E')
				return p;
			
			//2 up
			if(isOpen(p.row-2, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row-2, p.col, p));
			}
			
			//2 right
			if(isOpen(p.row, p.col+2)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col+2, p));
			}
			
			//2 down
			if(isOpen(p.row+2, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row+2, p.col, p));
			}
			
			//2 left
			if(isOpen(p.row, p.col-2)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col-2, p));
			}
			
			//1 up
			if(isOpen(p.row-1, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row-1, p.col, p));
			}
			
			//1 right
			if(isOpen(p.row, p.col+1)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col+1, p));
			}
		}
		
		return null;
	}
	
	private static boolean isOpen(int row, int col) {
		return(row>=0&&row<maze.length&&col>=0&&col<maze[row].length&&!closedSymbols.contains(maze[row][col]));
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("maze.dat"));
		int noOfSets = Integer.parseInt(scan.nextLine());
		while(noOfSets-->0) {
			int dimensions = Integer.parseInt(scan.nextLine());
			maze = new char[dimensions][dimensions];
			int rowStart = -1, colStart = -1;
			for(int i = 0;i<dimensions;i++) {
				char[] row = scan.nextLine().toCharArray();
				for(int a = 0;a<row.length;a++) {
					maze[i][a] = row[a];
					if(maze[i][a]=='S') {
						rowStart = i;
						colStart = a;
					}
				}
			}
			
			Point endPoint = find(rowStart, colStart);
			if(endPoint==null) {
				System.out.println("NOT POSSIBLE");
				continue;
			}
			int pathLength = 0;
			while(endPoint.parent!=null) {
				pathLength++;
				endPoint = endPoint.parent;
			}
			
			System.out.println(pathLength);
			
		}
		scan.close();
	}
}