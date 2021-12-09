import java.io.*;
import java.util.*;

public class Dennis {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("dennis.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int dim = scan.nextInt();
			scan.nextLine();
			char[][] arr = new char[100][dim];
			int max = 0;
			for(int i = 0; i<dim; i++) {
				char[] inp = scan.nextLine().toCharArray();
				if(max<inp.length)
					max = inp.length;
				for(int col = 0; col<inp.length; col++)
					arr[col][i]=inp[col];
				
			}
			for(int i = 0; i<max; i++) {
				for(int j = 0 ; j<dim; j++)
					System.out.print(arr[i][j]);
				if(i<max-1)
					System.out.println();
				}
			System.out.println();
			for(int i = 0; i<dim; i++)
				System.out.print("*");
			System.out.println();
		}
		
		
	}
}