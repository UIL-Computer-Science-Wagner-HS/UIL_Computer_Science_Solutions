import java.util.*;
import java.io.*;
public class Pr92 {
	static int[][] visited = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean solveMaze(char[][]arr,boolean[][]arr1,int a, int b) {
		Queue<int[]> line = new LinkedList<>();
		line.add(new int[] {a,b});
		arr1[a][b] = true;
		while(!line.isEmpty()) {
			int[] check = line.poll();
			for(int i = 0; i < 4; i ++) {
				int r = check[0] + visited[i][0];
				int c = check[1] + visited[i][1];
				if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && !arr1[r][c] && arr[r][c] != '#') {
					if (arr[r][c]=='E')
						return true;
					arr1[r][c] = true;
					line.add(new int[] {r,c});
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("pr92"));
		int x = sc.nextInt();
		while (x-- > 0) {
			
			int y = sc.nextInt();
			int  z = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[y][z];
			boolean[][] arr1 = new boolean[y][z];
			for (int i = 0; i < y; i ++)
				arr[i]= sc.nextLine().toCharArray();
			int a = 0;
			int b = 0;
			smth:
			for (int i = 0; i < arr.length; i ++)
				for ( int j = 0; j < z; j++) {
					if (arr[i][j]=='S') {
						a = i;
						b = j;
						break smth;
					}
				}
			//System.out.println(a + " " + b);
			boolean ans = solveMaze(arr,arr1,a,b);
			System.out.println(ans?"EXIT FOUND":"NO EXIT");
		}
		
		
	}

}
