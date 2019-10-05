import java.io.*;
import java.util.*;

public class Stelios {
	
	/**
	 * Class to represent a vertex.
	 * Keep track of parent in order
	 * to determine path length later.
	 * @author fernandesi2244
	 *
	 */
	static class Point{
		int location;
		Point parent;
		public Point(int l, Point parent) {
			location = l;
			this.parent = parent;
		}
	}
	
	LinkedList<Integer>[] vertices; //List of vertices
	int[][] connectionMatrix;		//Connection Matrix
	
	/**
	 * Initialize graph.
	 * @param no
	 */
	public Stelios(int no) {
		vertices = new LinkedList[no];
		for(int i = 0;i<vertices.length;i++)
			vertices[i] = new LinkedList<Integer>();
		
		connectionMatrix = new int[no][no];
	}
	
	/**
	 * Add bidirectional edge from a to b.
	 * @param a
	 * @param b
	 */
	public void addEdge(int a, int b) {
		vertices[a].add(b);
		vertices[b].add(a);
	}
	
	/**
	 * See if there is a point from start to end using a
	 * breadth-first search.
	 * @param start
	 * @param end
	 * @return
	 */
	public Point bfs(int start, int end) {
		boolean[] visited = new boolean[vertices.length];
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(start, null));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.remove();
			
			Iterator<Integer> it = vertices[p.location].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					if(n==end) {
						return new Point(n, p);
					}
					queue.add(new Point(n, p));
				}
			}
		}
		return null;
	}
	
	/**
	 * Print the connection matrix as specified by the 
	 * output in the problem description.
	 * @param mat
	 */
	private static void printArr(int[][] mat) {
		for(int[] a: mat) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		for(int i = 0;i<mat.length*2-1;i++)
			System.out.print("-");
		System.out.println();
	}

	/**
	 * Scan in graph and perform bfs on every pair possible.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("stelios.dat"));
		while(scan.hasNextLine()) {
			String[] nextLine = scan.nextLine().split("\\s");
			Stelios graph = new Stelios(Integer.parseInt(nextLine[0]));
			
			//Add edges to graph with integers instead of characters to make
			//other code simpler.
			for(int i = 1;i<nextLine.length;i++) {
				graph.addEdge(nextLine[i].charAt(0)-65, nextLine[i].charAt(1)-65);
			}
			/*
			 * Process each vertex pair possible and see if there is a path
			 * between them. If so, determine the length of the path, and if
			 * it's the shortest path, add the path length to the connection
			 * matrix.
			 */
			for(int i = 0;i<graph.vertices.length;i++) {
				for(int j = 0;j<graph.vertices.length;j++) {
					Point p = graph.bfs(i,j);
					if(p!=null) {
						int pathLength = 0;
						while(p.parent!=null) {
							pathLength++;
							p = p.parent;
						}
						if(graph.connectionMatrix[i][j]!=0) {
							if(pathLength<graph.connectionMatrix[i][j])
								graph.connectionMatrix[i][j] = pathLength;
						} else
							graph.connectionMatrix[i][j] = pathLength;
					}
				}
			}
			
			printArr(graph.connectionMatrix);
		}
		scan.close();

	}

}
