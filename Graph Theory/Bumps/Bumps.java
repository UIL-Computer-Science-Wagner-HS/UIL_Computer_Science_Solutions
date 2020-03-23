import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
* A+ Computer Science: 2019-2020 Packet 6, Problem 9 (Bumps)
*
* @author Ian Fernandes.
*/
public class Bumps {

	static HashMap<Character, Integer> charToInt = new HashMap<>();
	static int[][] adjMat;
	static boolean[][] edgeExists;
	static ArrayList<Integer> unvisited = new ArrayList<>();
	static int[] lastVertex;
	static int[] minDistanceFromSource;
	static int counter;

	static class Edge {
		private char from, to;
		private int weight;

		public Edge(char from, char to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	private static void registerVertex(char vertex) {
		if (!charToInt.containsKey(vertex)) {
			charToInt.put(vertex, counter++);
		}
	}

	private static void setUpDijkstra() {
		for (int i = 0; i < minDistanceFromSource.length; i++) {
			minDistanceFromSource[i] = Integer.MAX_VALUE;
			lastVertex[i] = -1;
			unvisited.add(i);
		}

		minDistanceFromSource[0] = 0;
	}

	private static void dijkstra() {
		while (unvisited.size() > 0) {
			int nextVertex = getNextMinVertex();
			unvisited.remove(Integer.valueOf(nextVertex));

			int[] adjacentVertices = adjMat[nextVertex];

			for (int i = 0; i < adjacentVertices.length; i++) {
				if (edgeExists[nextVertex][i]
						&& minDistanceFromSource[nextVertex] + adjMat[nextVertex][i] < minDistanceFromSource[i]) {
					minDistanceFromSource[i] = minDistanceFromSource[nextVertex] + adjMat[nextVertex][i];
					lastVertex[i] = nextVertex;
				}
			}
		}
	}

	private static int getNextMinVertex() {
		int minVertex = -1;
		int minDistanceSoFar = Integer.MAX_VALUE;

		for (int current : unvisited) {
			if (minDistanceFromSource[current] < minDistanceSoFar) {
				minDistanceSoFar = minDistanceFromSource[current];
				minVertex = current;
			}
		}

		return minVertex;
	}

	private static void printPath(int dest) {
		HashMap<Integer, Character> intToChar = new HashMap<>();
		Set<Entry<Character, Integer>> charToIntEntries = charToInt.entrySet();
		for (Entry<Character, Integer> current : charToIntEntries)
			intToChar.put(current.getValue(), current.getKey());

		ArrayList<Character> path = new ArrayList<>();

		while (lastVertex[dest] != -1) {
			path.add(intToChar.get(dest));
			dest = lastVertex[dest];
		}
		path.add('A');

		Collections.reverse(path);
		path.forEach(x -> System.out.print(x));
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("bumps.dat"));
		char dest = scan.nextLine().charAt(0);
		TreeSet<Character> vertices = new TreeSet<>();
		ArrayList<Edge> pairs = new ArrayList<>();

		while (scan.hasNextLine()) {
			String nextLine[] = scan.nextLine().split(" - ");
			char from = nextLine[0].split("/")[0].charAt(0);
			char to = nextLine[0].split("/")[1].charAt(0);
			int weight = Integer.parseInt(nextLine[1]);

			vertices.add(from);
			vertices.add(to);

			pairs.add(new Edge(from, to, weight));
		}

		Iterator<Character> it = vertices.iterator();
		while (it.hasNext())
			registerVertex(it.next());

		adjMat = new int[vertices.size()][vertices.size()];
		edgeExists = new boolean[vertices.size()][vertices.size()];
		lastVertex = new int[vertices.size()];
		minDistanceFromSource = new int[vertices.size()];

		for (Edge current : pairs) {
			int from = charToInt.get(current.from);
			int to = charToInt.get(current.to);

			adjMat[from][to] = current.weight;
			edgeExists[from][to] = true;
		}

		setUpDijkstra();

		dijkstra();

		printPath(charToInt.get(dest));

		scan.close();
	}
}
