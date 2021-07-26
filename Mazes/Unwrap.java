import java.io.*;
import java.util.*;

public class Unwrap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("unwrap.dat"));
		int dim = scan.nextInt();
		// scan.nextLine();
		int[][] arr = new int[dim][dim];

		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
				arr[i][j] = scan.nextInt();
		List<Integer> list = new ArrayList();
		int pointer = 0;
		if (dim % 2 == 1||dim%2==0) {
			while (pointer <= dim /2) {
				for (int j = pointer; j < dim - pointer; j++)
					list.add(arr[pointer][j]);
				for (int i = pointer + 1; i < dim - pointer; i++)
					list.add(arr[i][dim - pointer-1]);
				for (int j = dim - pointer - 2; j >=pointer ; j--)
					list.add(arr[dim - pointer-1][j]);
				for (int i = dim - pointer - 2; i >= pointer + 1; i--)
						list.add(arr[i][pointer]);
				pointer++;

			}
			list.add(arr[dim/2][dim/2]);
			for(int i = 1; i<list.size(); i++){
				System.out.print(list.get(i-1)+" ");
				
				if(i%10==0)
					System.out.println();
				
			}
		}
	}
}
