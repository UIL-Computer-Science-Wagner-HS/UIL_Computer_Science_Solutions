import java.io.*;
import java.util.*;

public class Run {

	static int solve(int dim, int[][] arr) { //this is just a breath first search.  This works if all the distances are 1.
		int ans = 10000;
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[dim];
		int[] check = { dim - 1, 1 };
		q.add(check);
		visited[dim - 1] = true;
		while (!q.isEmpty()) {
			check = q.poll();
			int row = check[0];
			int haveChecked = dim-1;
			//System.out.println("row "+row);
			for (int i = 0; i < dim; i++) {
				if (i != row && !visited[i] && arr[row][i] == 1) {
					//System.out.println("I:" + i);
					haveChecked = i;
					if (i == 0) {
						return check[1];//ans = //Math.min(check[1], ans);//if the distances are not one you try this
					} else {
						q.add(new int[] { i, check[1] + 1 });
					}
				}

			}
			visited[haveChecked] = true;

		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("run.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			int dist = scan.nextInt();
			int dim = scan.nextInt();
			int[][] arr = new int[dim][dim];
			for (int i = 0; i < dim; i++)
				for (int j = 0; j < dim; j++)
					arr[i][j] = scan.nextInt();
			// System.out.println("dim-1 "+(dim-1));
			int n = solve(dim, arr);
			System.out.println(n<dist? "Safe at last": "This is the end of me!");
			//System.out.println();

		}

	}

}