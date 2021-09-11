
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class GofLife {

	static int sum(int[][] arr, int i, int j) {
		int ans = 0;
		for (int row = i - 1; row <= i + 1; row++)
			for (int col = j - 1; col <= j + 1; col++) {
				ans += arr[col][row];
				
			}
		ans -= arr[i][j];
		return ans;

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("life.dat"));
		int dim = scan.nextInt();
		scan.nextLine();

		int[][] arr = new int[dim + 2][dim + 2];
		char[][] cArr = new char[dim + 2][dim + 2];
		for (int i = 0; i < dim; i++)
			cArr[i] = scan.nextLine().toCharArray();
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++) {

				arr[i + 1][j + 1] = Integer.parseInt(Character.toString(cArr[i][j]));

			}
		int days = scan.nextInt();

		while (days-- > 0) {
			int[][] working = new int[dim + 2][dim + 2];
			for (int i = 1; i < dim + 1; i++) {
				for (int j = 1; j < dim + 1; j++) {
					int sum = sum(arr, i, j);
					if(arr[i][j]==1) {
						if( sum<2||sum>3)
							working[i][j]= 0;
						else 
							working[i][j]= 1;
						
						
					}
					else
						if(sum ==3)
							working[i][j]=1;
						else working[i][j]=0;

				}
			}
			arr = working;
			 working = new int[dim + 2][dim + 2];
			 for(int i = 1; i<dim+1; i++) {
				 for(int j = 1; j<dim+1; j++)
					 System.out.print(arr[i][j]);
			System.out.println();  
			 }
System.out.println(); 

		}

	}

}
