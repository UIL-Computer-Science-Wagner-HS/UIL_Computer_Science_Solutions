import java.io.*;
import java.util.*;

public class pr59 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr59.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0){
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			for(int i = 0; i<rows; i++){
				int [] arr = new int[cols];
				for(int j = 0; j<cols; j++)
					arr[j]= scan.nextInt();
				Arrays.sort(arr);
				for(int n: arr)
					System.out.printf("%4d",n);
				System.out.println();	
				
			}
			System.out.println(); 
			
			
			
		}
		

	}
}
