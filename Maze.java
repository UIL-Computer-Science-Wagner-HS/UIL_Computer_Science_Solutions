import java.util.*;
import java.io.*;

/**
 * This class determines the length of the shortest path from 'S' to 'E' using a Breadth-first Traversal.
 * @author fernandesi2244
 *
 */
public class Maze {
	
	private static char[][] maze;
	private static Queue<Point> queue = new LinkedList<>();
	private static ArrayList<Character> closedSymbols = new ArrayList<>(Arrays.asList('#', '+'));
	
	/**
	 * Class to keep track of a point, its location in the maze, and its parent.
	 * The parent is necessary to keep track of so that we can determine the length of the
	 * path later.
	 * @author fernandesi2244
	 *
	 */
	static class Point {
		int row, col;
		Point parent;
		
		public Point(int row, int col, Point parent) {
			this.row = row;
			this.col = col;
			this.parent = parent;
		}
	}
	
	/**
	 * Method to solve the minimum path to the end-point.
	 * This method represents an altered breadth-first traversal of a graph.
	 * Normally, there would be nodes in a graph, but each cell in a 2-dimensional 
	 * array will suffice to form a graph.
	 * @param row the row index of the point being examined.
	 * @param col the column index of the point being examined
	 * @return
	 */
	private static Point find(int row, int col) {
		//Add the starting point to the queue
		queue.add(new Point(row, col, null));
		
		//While there are no more nodes to check or the end point has not yet been found:
		while(!queue.isEmpty()) {
			
			//Pull off the first element of the queue (FIFO)
			Point p = queue.poll();
			
			//If it's the end point, return the point.
			if(maze[p.row][p.col]=='E')
				return p;
			
			//If the node 2 places above the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row-2, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row-2, p.col, p));
			}
			
			//If the node 2 places to the right of the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row, p.col+2)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col+2, p));
			}
			
			//If the node 2 places below the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row+2, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row+2, p.col, p));
			}
			
			//If the node 2 places to the left of the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row, p.col-2)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col-2, p));
			}
			
			//If the node 1 place above the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row-1, p.col)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row-1, p.col, p));
			}
			
			//If the node 1 place to the right of the current node is free, add it to the queue and mark the current node as part of the path.
			if(isOpen(p.row, p.col+1)) {
				maze[p.row][p.col] = '+';
				queue.add(new Point(p.row, p.col+1, p));
			}
		}
		
		//At this point, there are no more elements in the queue, and therefore, a path to the end-point was not found. Return null to indicate
		//absence of path.
		return null;
	}
	
	/**
	 * Helper method to determine if a given node in the maze is open (Is not a wall, has not been marked, and is not outside of the array)
	 * @param row row index to check
	 * @param col column index to check
	 * @return whether the given node can be added to the path
	 */
	private static boolean isOpen(int row, int col) {
		return(row>=0&&row<maze.length&&col>=0&&col<maze[row].length&&!closedSymbols.contains(maze[row][col]));
	}
	
	/**
	 * Read in the 2-dimensional arrays from the input file.
	 * Use results of find() method to print findings to the screen.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("maze.dat"));
		int noOfSets = Integer.parseInt(scan.nextLine());
		
		//While there are still data-sets to scan:
		while(noOfSets-->0) {
			int dimensions = Integer.parseInt(scan.nextLine());
			maze = new char[dimensions][dimensions];
			int rowStart = -1, colStart = -1;
			for(int i = 0;i<dimensions;i++) {
				//Scan in the row and convert to an array
				char[] row = scan.nextLine().toCharArray();
				
				//Update maze correctly
				for(int a = 0;a<row.length;a++) {
					maze[i][a] = row[a];
					//Keep track of starting point
					if(maze[i][a]=='S') {
						rowStart = i;
						colStart = a;
					}
				}
			}
			
			Point endPoint = find(rowStart, colStart);
			
			//If no path was found
			if(endPoint==null) {
				System.out.println("NOT POSSIBLE");
				continue; //continues to the next iteration of the while loop
			}
			
			//Otherwise, count the length of the path.
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