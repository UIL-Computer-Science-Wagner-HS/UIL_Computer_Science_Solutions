import java.io.*;
import java.util.*;

public class CSquares {
	
	static void draw(char[][] arr, int n) {
		Arrays.fill(arr[n], n,arr.length-n,'*');
		Arrays.fill(arr[arr.length-n-1], n,arr.length-n,'*');
		for(int j = n; j<arr.length-n-1; j++)
			arr[j][n]='*';
		for(int j = n; j<arr.length-n-1; j++)
			arr[j][arr.length-1-n]='*';
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("csquares.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int n = scan.nextInt();
			int dim = 2*n-1;
			char[][] arr = new char[dim][dim];
			if(n%2==0) {
			for(int i = 0; i<n; i+=2)
				draw(arr,i);
		
			for(char[] r: arr) {
				for(char c: r)
					System.out.print(c);
				System.out.println();
			}
			System.out.println();
				
		}
			
		
		}
		var var = new Stack<String>();
	}
}


