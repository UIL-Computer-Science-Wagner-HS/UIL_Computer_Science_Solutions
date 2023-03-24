import java.io.*;
import java.util.*;

public class Diamonds {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("diamonds.dat"));
		int noSets = scan.nextInt();
		while (noSets-- > 0) {
			char c = scan.next().charAt(0);
			int dim = scan.nextInt();
			char[][] maze = new char[dim][dim];
			int dis = 0;
			int middle = dim / 2;
			for (int i = 0; i <= middle; i++) {
				maze[i][middle - i] = 'c';
				maze[i][middle + i] = 'c';
				maze[dim - 1 - i][middle - i] = 'c';
				maze[dim - 1 - i][middle + i] = 'c';

			}
			for(char[] r: maze) {
				for(char c1: r) {
					System.out.print(c1);
					}
				System.out.println();
			}
					

		}
	}
}
