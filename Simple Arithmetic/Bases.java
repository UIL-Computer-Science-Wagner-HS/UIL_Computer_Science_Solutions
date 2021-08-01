import java.io.*;
import java.util.*;

public class Bases {
	public static void main(String[] args) throws FileNotFoundException {
	Scanner scan = new Scanner(new File("bases.dat"));
	System.out.println("Base 10   Base 2   Base 4   Base 8   Base 12   Base 16");
	int inp = scan.nextInt();
	int[] arr = {10, 2,4,8,12,16};
	for (int i = 1; i<=inp; i++){
		for(int k = 0; k<arr.length; k++)
		System.out.printf("%-10s",Integer.toString(i,arr[k]));
		System.out.println(); 
		
		
		
	}
	}
}
