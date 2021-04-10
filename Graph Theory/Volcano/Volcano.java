/*Region UIL 2014 Solution - #10 - Volcano
Test data
7
5 5
WWS.T
..T.C
.....
.W...
.VWW.
3 10
WWWCTTT...
WWW.TTT...
S...TTV...
1 6
VWC.TS
1 6
VTC.TS
1 6
VTC.WS
20 20
CW.................V
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
S...................
20 20
CV..................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
....................
WW..................
..W.................
...W................
....W...............
S....W..............
Output
NO
YES
NO
YES
NO
NO
NO
*/
import java.io.*;
import java.util.*;

public class Volcano {

	public static final int[][] steps = {
		{0, 1},
		{1, 0},
		{0, -1},
		{-1, 0},
	};

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(new File("volcano.dat"));
		int T = scan.nextInt();

		while (T-- > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int sR = 0, sC = 0, vR = 0, vC = 0;
			char[][] forest1 = new char[n][m];
			char[][] forest2 = new char[n][m];
			char[][] forest3 = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = scan.next();
				for (int j = 0; j < m; j++) {
					forest1[i][j] = line.charAt(j);
					forest2[i][j] = line.charAt(j);
					forest3[i][j] = line.charAt(j);
					if (forest1[i][j] == 'S') {
						sR = i;
						sC = j;
					} else if (forest1[i][j] == 'V') {
						vR = i;
						vC = j;
					}
				}
			}

			int s = find(forest1, sR, sC, false, 'C');
			int v = find(forest2, vR, vC, true, 'C');
			int v2 = find(forest3, vR, vC, true, 'S');

			if ((s < v && s != -1) || v2 == -1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

		scan.close();
	}

	public static int find(char[][] forest, int row, int col, boolean lava, char goal) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(row);
		q.add(col);
		q.add(0);

		while (!q.isEmpty()) {
			int r = q.poll(), c = q.poll(), cost = q.poll();
			if (r < 0 || r >= forest.length ||
				c < 0 || c >= forest[r].length ||
				(forest[r][c] == 'T' && !lava) ||
				forest[r][c] == 'W') {
				continue;
			}

			if (forest[r][c] == goal) {
				return cost;
			}

			forest[r][c] = 'W';

			for (int[] step : steps) {
				q.add(step[0] + r);
				q.add(step[1] + c);
				q.add(cost + 1);
			}
		}

		return -1;
	}
}
