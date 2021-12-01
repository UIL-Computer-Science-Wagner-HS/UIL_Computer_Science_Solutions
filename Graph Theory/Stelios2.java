/*
Goal here is to input a graph and output the connection matrix.  
Idea is to use the adjacency matrix multiplied by itself enough times so that all the elements in the matrix are nonzero (except a to a etc)
Count the number of times we are forced to multiply and insert this counter in the element which has just become nonzero. 




*/
import java.util.*;
import java.io.*;

public class Stelios2 {

	static boolean[] visited;
	static int[][] answer;

	static int mult(int[][] a, int[][] b, int i, int j) {
		int sum = 0;
		int dim = a.length;
		for (int row = 0; row < dim; row++)
			sum += a[i][row] * b[row][j];
		return sum;

	}

	static int[][] mult(int[][] a, int[][] b) {
		int[][] ans = new int[a.length][b.length];
		int dim = a.length;
		for (int i = 0; i < dim; i++) {
			int input = 0;
			for (int j = 0; j < dim; j++) {
				ans[i][j] = mult(a, b, i, j);

			}

		}
		return ans;
	}

	static boolean check(int[][] arr) {
		boolean ans = true;
		int dim = arr.length;
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				if (i != j && arr[i][j] == 0)
					return false;

		return ans;
	}

	static void fix(int[][] mult, int[][] answer, int toAdd) {
		int dim = mult.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i != j && answer[i][j] == 0 && mult[i][j] != 0)
					answer[i][j] = toAdd;

			}

		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("stelios.dat"));
		while (scan.hasNextLine()) {
			String[] input = scan.nextLine().split(" ");
			int dim = Integer.parseInt(input[0]);
			int[][] arr = new int[dim][dim];
			answer = new int[dim][dim];
			Map<Character, Integer> map = new HashMap();
			int index = 0;
			for (int i = 0; i < dim; i++) {
				map.put((char) (i + 65), index++);

			}

			for (int i = 1; i < dim + 1; i++) {
				char first = input[i].charAt(0);
				char second = input[i].charAt(1);

				arr[map.get(first)][map.get(second)] = 1;
				arr[map.get(second)][map.get(first)] = 1;

			}

			answer = new int[dim][dim];
			for (int i = 0; i < dim; i++)
				answer[i] = Arrays.copyOf(arr[i], dim);
			int[][] mult = new int[dim][dim];
			for (int i = 0; i < dim; i++)
				mult[i] = Arrays.copyOf(arr[i], dim);
			int counter = 1;
			while (true) {
				if (check(answer))
					break;
				mult = mult(mult, arr);
				counter++;
				fix(mult, answer, counter);

			}

			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < dim; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();

			}
			for (int i = 0; i < answer.length * 2 - 1; i++)
				System.out.print("-");
			System.out.println();

		}

	}

}
