
/*6
S.....
XXXXX.
..XX..
......
.XXXXX
.....E */
import java.io.*;
import java.util.*;

public class Maze17jul1 {
	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	// this stores an optimal path
	static List<PointM> list = new ArrayList();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("maze1.dat"));
		int dim = scan.nextInt();
		char[][] maze = new char[dim][dim];
		boolean[][] visited = new boolean[dim][dim];
		PointM start = null;
		PointM end = null;

		for (int i = 0; i < dim; i++) {
			maze[i] = scan.next().toCharArray();
			for (int j = 0; j < dim; j++) {
				if (maze[i][j] == 'S') {
					start = new PointM(i, j, null);
				}
				if (maze[i][j] == 'E') {
					end = new PointM(i, j, null);
				}

			}
		}
		// start the breadth first search
		Queue<PointM> queue = new LinkedList();
		queue.add(start);
		while (!queue.isEmpty()) {
			PointM check = queue.poll();
			visited[check.x][check.y] = true;
			// have we finished?
			if (check.x == end.x && check.y == end.y) {
				System.out.println("solved");
				// now backtrack the winning path. stop when at start
				PointM backwards = check;
				while (backwards.previous != null) {
					list.add(backwards);
					backwards = backwards.previous;
				}

				break;
			}
			for (int n = 0; n < 4; n++) {
				int cX = check.x + moves[n][0];
				int cY = check.y + moves[n][1];
				if (cX >= 0 && cY >= 0 && cX < dim && cY < dim && !visited[cX][cY]
						&& (maze[cX][cY] == '.' || maze[cX][cY] == 'E')) {
					visited[cX][cY] = true;

					queue.add(new PointM(cX, cY, check));
				}
			}
		}

		if (list.size() == 0)
			System.out.println("no way");
		for (PointM p : list)
			System.out.println(p.x + "," + p.y);
	}
}

class PointM {
	int x;
	int y;
	PointM previous;

	public PointM(int x, int y, PointM previous) {
		super();
		this.x = x;
		this.y = y;
		this.previous = previous;
	}

}
