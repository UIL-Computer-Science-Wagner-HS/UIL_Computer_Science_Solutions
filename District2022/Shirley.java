import java.io.*;
import java.util.*;



public class Shirley {
	int acre;
	double percent;
	
	
	public Shirley(int acre, double percent) {
		super();
		this.acre = acre;
		this.percent = percent;
	}

	static int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	/*
	 * static int[] find(int[][] working) { for(int i = 0; i<working.length; i++)
	 * for(int j = 0; j<working[0].length; j++) { if(working[i][j]==0) return new
	 * int[] {i,j};
	 * 
	 * } return new int[] {-1,-1}; }
	 */
	static int fix(int[][] arr, int[][] working) {
		int n = 1;
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] < 250)
					working[i][j] = -1;

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (working[i][j] == 0)
					fill(arr, working, n++, i, j);
		return n;

	}

	static void fill(int[][] arr, int[][] working, int n, int i, int j) {
		working[i][j] = n;
		int[] start = { i, j };
		Stack<int[]> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			int[] check = stack.pop();
			for (int k = 0; k < moves.length; k++) {
				int row = moves[k][0] + check[0];
				int col = moves[k][1] + check[1];
				if (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && working[row][col] == 0) {
					working[row][col] = n;
					stack.push(new int[] { row, col });

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("shirley.dat"));
		int noSets = scan.nextInt();
		int caseNo = 1;
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int[][] arr = new int[rows][cols];
			int[][] working = new int[rows][cols];
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
					arr[i][j] = scan.nextInt();
			int n = fix(arr, working)-1;
			
			List<Shirley> list = new ArrayList<>();
			Comparator<Shirley> comp = (a,b)->b.acre-a.acre;
			for(int i1 = 1; i1<=n;i1++ ) {
				int sum = 0;
				double count = 0;
						
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						if(working[i][j]==i1) {
							count++;
							sum+=arr[i][j];
							
						}
						
					}
				}
				//System.out.println("count "+count+"sum");
				if(count>1)
				list.add(new Shirley(sum, count/(rows*cols)*100));
				
			}
			Collections.sort(list, comp);
			System.out.println("Case #" + (caseNo++) + ":");
			int number = Math.min(3, list.size());
			for(int k = 0; k<number; k++)
				System.out.printf("%d %.1f\n",list.get(k).acre, list.get(k).percent);
			for(int i = 0; i<3-list.size(); i++)
				System.out.println("NONE");
			System.out.println("^^^^^^^^^^");

		}

	}

}