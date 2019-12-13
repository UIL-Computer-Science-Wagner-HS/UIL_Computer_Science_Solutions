package graphs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a weighted, undirected graph G, find the shortest path from vertex A to
 * vertex B.
 * 
 * See problem description for more information.
 * 
 * @author Ian Fernandes
 *
 */
public class pr132 {

	/**
	 * Holds at index i the shortest distance from vertex i to to the source vertex
	 */
	static int[] distancesFromSource;

	/**
	 * Graph representation carried out in adjacency matrix
	 */
	static int[][] adjMat;

	/**
	 * Holds the unvisited vertices with the highest priority given to the vertex
	 * with shortest distance from the source vertex
	 */
	static Queue<Integer> unvisited;

	/**
	 * Class to represent an edge pair from the input so that each pair can be
	 * processed later.
	 *
	 */
	static class Pair {
		String first, second; // vertices connected by edge
		int weight; // weight of edge

		/**
		 * Construct an edge pair with two vertices and an edge weight.
		 * 
		 * @param first  vertex 1
		 * @param second vertex 2
		 * @param weight edge weight
		 */
		public Pair(String first, String second, int weight) {
			this.first = first;
			this.second = second;
			this.weight = weight;
		}
	}

	/**
	 * Run Dijkstra's Shortest Path Algorithm on the adjacency matrix.
	 */
	private static void dijkstrasAlgorithm() {
		while (!unvisited.isEmpty()) {
			int currentVertex = unvisited.remove();
			int[] adjacentNeighbors = adjMat[currentVertex];

			for (int i = 0; i < adjacentNeighbors.length; i++) {
				if (adjacentNeighbors[i] != 0 && unvisited.contains(i)) {
					int distanceFrom0 = distancesFromSource[currentVertex] + adjacentNeighbors[i];
					if (distanceFrom0 < distancesFromSource[i]) {
						distancesFromSource[i] = distanceFrom0;
					}
				}
			}

			// Refresh the priority queue, as the new unvisited vertex with the shortest
			// distance from the source might have changed.
			refreshQueue();
		}
	}

	/**
	 * Refreshes priority queue to ensure that the next element that is removed from
	 * the queue is the unvisited vertex with the shortest distance from the source.
	 */
	private static void refreshQueue() {
		HashSet<Integer> removed = new HashSet<>();
		while (!unvisited.isEmpty()) {
			removed.add(unvisited.remove());
		}
		removed.forEach(x -> unvisited.add(x));
	}

	/**
	 * Resets the data structures that need to be reset after each test case.
	 * 
	 * Resets of array that holds the shortest distance of a particular vertex from
	 * the source vertex (All values = "Infinity").
	 * 
	 * Also adds all the vertices back to unvisited.
	 * 
	 * @param vertices
	 * @param stringToInt
	 */
	private static void resetDataStructures(HashSet<String> vertices, HashMap<String, Integer> stringToInt) {
		for (int i = 0; i < distancesFromSource.length; i++) {
			distancesFromSource[i] = Integer.MAX_VALUE;
		}

		for (String a : vertices) {
			unvisited.add(stringToInt.get(a));
		}
	}

	/**
	 * Debugging method to print basic array and queue contents
	 */
	private static void debug() {
		for (int[] a : adjMat) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

		System.out.print("Unvisited: ");
		System.out.println(unvisited);
		System.out.println("Distances: ");
		System.out.println(Arrays.toString(distancesFromSource));
	}

	/**
	 * Handle input according to problem specifications.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr132.dat"));

		// Contains edge pairs to processed later
		ArrayList<Pair> pairs = new ArrayList<>();

		// Contains unique vertices (used to determine # of vertices)
		HashSet<String> vertices = new HashSet<>();

		// Converts string values to integer values for easier graph manipulation
		HashMap<String, Integer> stringToInt = new HashMap<>();

		// Start string-to-int conversions with an id of 0 (for n vertices, id should
		// range from 0 to n-1 inclusive).
		int nextCharValue = 0;

		int noEdgePairs = Integer.parseInt(scan.nextLine());

		// Scan in each edge pair and process accordingly.
		while (noEdgePairs-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			String first = currentLine[0];
			String second = currentLine[1];
			int weight = Integer.parseInt(currentLine[2]);

			pairs.add(new Pair(first, second, weight));
			vertices.add(first);
			vertices.add(second);
			if (!stringToInt.containsKey(first)) {
				stringToInt.put(first, nextCharValue++);
			}
			if (!stringToInt.containsKey(second)) {
				stringToInt.put(second, nextCharValue++);
			}
		}

		// Instantiate distance array and adjacency matrix
		int noVertices = vertices.size();
		distancesFromSource = new int[noVertices];
		adjMat = new int[noVertices][noVertices];

		// Construct adjacency matrix
		for (Pair p : pairs) {
			int firstValue = stringToInt.get(p.first);
			int secondValue = stringToInt.get(p.second);
			int weight = p.weight;

			adjMat[firstValue][secondValue] = weight;
			adjMat[secondValue][firstValue] = weight;
		}

		// Define behavior of priority queue so that vertex with the least distance from
		// the source vertex is at the head position (removed first).
		unvisited = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer first, Integer second) {
				return distancesFromSource[first] - distancesFromSource[second];
			}

		});

		// Scan through each test case and calculate results.
		int noCases = Integer.parseInt(scan.nextLine());
		while (noCases-- > 0) {
			resetDataStructures(vertices, stringToInt);
			String[] currentLine = scan.nextLine().split(" ");
			int source = stringToInt.get(currentLine[0]);
			int destination = stringToInt.get(currentLine[1]);

			//Source vertex is a distance of 0 from itself (Also allows dijkstra's algo to start from source)
			distancesFromSource[source] = 0;
			refreshQueue();

			//////////////////////
			dijkstrasAlgorithm();
			//////////////////////

			System.out.println(distancesFromSource[destination]);
		}

		scan.close();

	}

}
