import java.util.*;
import java.io.*;

public class Tushar {
	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("tushar.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			//System.out.println(rows+" "+cols);
			int[][] arr = new int[rows][cols];
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++)
					arr[i][j] = scan.nextInt();
			// do top
			for(int j = 0;j<cols;j++ ) {
				int sum = 0;
				int k = j;
				int i = 0;
				for( ;k<cols&&i<rows; k++,i++ )
					sum+=arr[i][k];
				System.out.printf("%3.2f " ,(1.0*sum/(i)));
				
			}
			//do bottom
			for(int i = 0;i<rows;i++ ) {
				int sum = 0;
				int k = i;
				int j = 0;
				for( ;k<rows&&j<cols; k++,j++ )
					sum+=arr[k][j];
				System.out.printf("%3.2f " ,(1.0*sum/(j)));
				
			}
			System.out.println();
		

		}
	}

}
