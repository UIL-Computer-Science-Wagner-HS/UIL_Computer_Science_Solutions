import java.io.*;
import java.util.*;

public class Kiara {

	static void fill(char[][] arr, int r, int c, char c1) {
		if(r<0||r>=arr.length||c<0||c>=arr.length||arr[r][c]!=c1)
			return;
		arr[r][c]='-';
		fill(arr,  r+1, c, c1);
		fill(arr,  r-1, c,c1);
		fill(arr,  r, c+1,c1);
		fill(arr,  r, c-1,c1);
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("kiara.dat"));
		while (scan.hasNextLine()) {
			int dim = scan.nextInt();
			scan.nextLine();
			char[][] arr = new char[dim][];
			for(int i = 0; i<dim; i++)
				arr[i]= scan.nextLine().toCharArray();
			char c1 = arr[dim/2][dim/2];
			char c2;
			if(c1=='.')
				c2='#';
			else c2='.';
			fill(arr, dim/2, dim/2, c1);
			for(char[] ca: arr) {
				for(char c: ca)
					System.out.print(c);
				System.out.println();
			}
			System.out.println();
			
			
			
		}
				
				
				
				
				
		
	}

}
