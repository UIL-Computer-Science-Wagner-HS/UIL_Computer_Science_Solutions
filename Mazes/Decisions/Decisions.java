import java.io.*;
import java.util.*;



public class Decisions {
	static List<int[]> list = new ArrayList();

	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	static void solve(char[][] arr, boolean[][] visited, int[] location) {
		int steps = 0;
		list = new ArrayList();
		Queue<int[]> queue = new LinkedList();
		queue.add(location);
		while (!queue.isEmpty()) {
			int[] check = queue.poll();
			visited[check[0]][check[1]] = true;
			if (arr[check[0]][check[1]] == 'W') {
				list.add(new int[] { check[0], check[1], check[2] });

			}
			for (int i = 0; i < 4; i++) {
				int row = check[0] + moves[i][0];
				int col = check[1] + moves[i][1];
				steps = check[2];
				if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length && !visited[row][col]
						&& arr[row][col] != '#') {
					queue.add(new int[] { row, col, steps + 1 });

				}

			}

			list.forEach(a->Arrays.toString(a));
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("decisions.dat"));
		int noSets = scan.nextInt();
		int steps = 0;
		while (noSets-- > 0) {
			int row = scan.nextInt();
			int col = scan.nextInt();
			char[][] arr = new char[row][col];
			boolean[][] visited = new boolean[row][col];
			scan.nextLine();
			for (int i = 0; i < row; i++)
				arr[i] = scan.nextLine().toCharArray();
			int xW = 0;
			int yW = 0;
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 'R') {
						solve(arr, visited, new int[] { i, j, steps });

					}

				}
			Comparator<int[]> comp = (a, b) -> {
				if(a[2]!=b[2])
					return a[2]-b[2];
				if (a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			};
			list.sort(comp);
			//for(int[] a: list)
				//System.out.println(Arrays.toString(a));
			if (list.size() > 0)
				System.out.println(list.get(0)[0] + " " + list.get(0)[1]);
			else System.out.println("Send a helicopter");
		}
	}
}