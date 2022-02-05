import java.io.*;
import java.util.*;

public class Huang {
	public static void main(String... args) throws IOException {
		Scanner sc = new Scanner(new File("huang.dat"));

		while (sc.hasNextLine()) {
			String str = sc.next();
			int len = str.length();
			int dim = sc.nextInt();
			int[][] arr = new int[dim][dim];
			int left = 0;
			int right = dim - 1;
			int up = 0;
			int down = dim - 1;
			System.out.println(down);
			int dir = 0;
			int counter = 0;
			int j = 0;
			int i = 0;
			while (counter < dim * dim) {
				while (dir == 0) {
					while (j <= right) {
						//System.out.println(i+ "dir0 "+j);
						arr[i][j++] = counter % len;
						counter++;
					}
					j--;
					up++;
					dir = 1;
					i++;

				}
				while (dir == 1) {
					while (i <= down) {
						//System.out.println(i+ "dir1 "+j);
						arr[i++][j] = counter % len;
						counter++;
					}
					right--;
					i--;
					j--;
					dir = 2;

				}

				while (dir == 2) {
					while (j >= left) {
						//System.out.println(i+ "dir2 "+j);
						arr[i][j--] = counter % len;
						counter++;
					}
					down--;
					j++;
					i--;
					dir = 3;

				}

				while (dir == 3) {
					while (i >= up) {
						//System.out.println(i+ "dir3 "+j);
						arr[i--][j] = counter % len;
						counter++;

					}
					i++;
					j++;
					dir = 0;
					left++;

				}

			}
			char[][] ans = new char[dim][dim];
			for (i  = 0; i<dim; i++)
				for(j =0; j<dim; j++)
					ans[i][j]= str.charAt(arr[i][j]);
			ans[dim/2][dim/2]='*';
			for(char[] row: ans)
				System.out.println(Arrays.toString(row));

		}
	}
}

/*
 * while (sum<20) { while(dir==0){ if (j <= right) {
 * System.out.println(i+" "+j); arr[i][j] = counter; counter = (counter + 1) %
 * len; j++; sum++;
 * 
 * } if(j>right){ up++; dir = 1; j--; i++;
 * 
 * } } while (dir == 1) { if (i <= down) { System.out.println(i+" "+j);
 * arr[i][j] = counter; counter = (counter + 1) % len; i++; sum++; } if(i>down){
 * right--; dir=2; j--; i--; up--;
 * 
 * } } while (dir == 2) { if (j >=left) { System.out.println(i+" "+j); arr[i][j]
 * = counter; counter = (counter + 1) % len; j--; sum++; } if(j <left){ down--;
 * dir=3; j++; i--; continue; } } while (dir == 3) { if (i >= up) {
 * System.out.println(i+" "+j); arr[i][j] = counter; counter = (counter + 1) %
 * len; i--; sum++; } if(i>up){ i++; left++; dir = 0; } sum++; }
 * 
 * 
 */