import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Travel {
	static int[][] adjMat;
	static int[] shortestDistanceFromSource;
	static int[] lastVertex;
	static HashMap<String, Integer> planetToNum = new HashMap<>();
	static int nextVertexNo;
	static HashSet<Integer> inTree = new HashSet<>();
	static ArrayList<Integer> notInTree = new ArrayList<>();

	static class PlanetEntry {
		String from, to;
		int weight;

		public PlanetEntry(String from, String to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	private static void reset() {
		shortestDistanceFromSource = new int[adjMat.length];
		lastVertex = new int[adjMat.length];

		for (int i = 0; i < shortestDistanceFromSource.length; i++)
			shortestDistanceFromSource[i] = Integer.MAX_VALUE;
		for (int i = 0; i < lastVertex.length; i++)
			lastVertex[i] = -1;

		for (int i = 0; i < adjMat.length; i++)
			notInTree.add(i);

	}

	private static void dijkstra() {
		while (inTree.size() < adjMat.length) {
			int currentVertex = getNextMinVertex(); // make sure this doesn't evaluate to -1
			inTree.add(currentVertex);
			for (int i = 0; i < adjMat[currentVertex].length; i++) {
				if (adjMat[currentVertex][i] != 0 && shortestDistanceFromSource[currentVertex]
						+ adjMat[currentVertex][i] < shortestDistanceFromSource[i]) {
					shortestDistanceFromSource[i] = adjMat[currentVertex][i]
							+ shortestDistanceFromSource[currentVertex];
					lastVertex[i] = currentVertex;
				}
			}
		}
	}

	private static int getNextMinVertex() {
		int min = Integer.MAX_VALUE;
		int minVertex = -1;
		for (int i = 0; i < shortestDistanceFromSource.length; i++) {
			if (shortestDistanceFromSource[i] < min && !inTree.contains(i)) {
				min = shortestDistanceFromSource[i];
				minVertex = i;
			}
		}

		return minVertex;
	}

	static ArrayList<Integer> path = new ArrayList<>();

	private static void recursePath(int end) {
		if (end == -1)
			return;
		path.add(0, end);
		recursePath(lastVertex[end]);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("travel.dat"));
		int no = Integer.parseInt(scan.nextLine());

		ArrayList<PlanetEntry> entries = new ArrayList<>();

		while (no-- > 0) {
			String[] nextLine = scan.nextLine().split(" ");
			String fromPlanet = nextLine[0];
			String toPlanet = nextLine[1];
			int weight = Integer.parseInt(nextLine[2]);

			if (!planetToNum.containsKey(fromPlanet))
				planetToNum.put(fromPlanet, nextVertexNo++);
			if (!planetToNum.containsKey(toPlanet))
				planetToNum.put(toPlanet, nextVertexNo++);

			entries.add(new PlanetEntry(fromPlanet, toPlanet, weight));
		}

		adjMat = new int[planetToNum.keySet().size()][planetToNum.keySet().size()];
		for (PlanetEntry entry : entries) {
			int fromPlanet = planetToNum.get(entry.from);
			int toPlanet = planetToNum.get(entry.to);
			int weight = entry.weight;

			adjMat[fromPlanet][toPlanet] = weight;
		}

		reset();

		int start = planetToNum.get(scan.next());
		int end = planetToNum.get(scan.next());

		shortestDistanceFromSource[start] = 0;

		dijkstra();

		recursePath(end);

		HashMap<Integer, String> intToString = new HashMap<>();
		Set<Entry<String, Integer>> s = planetToNum.entrySet();
		for (Entry<String, Integer> a : s) {
			intToString.put(a.getValue(), a.getKey());
		}

		for (int i = 0; i < path.size() - 1; i++) {
			System.out.print(intToString.get(path.get(i)) + " to ");
		}
		System.out.println(intToString.get(path.get(path.size() - 1)) + ".");

		scan.close();

	}

}
