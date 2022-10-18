import java.io.*;
import java.util.*;


public class Changpu {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("changpu.dat")); // scanning in the data file
		
		while (scan.hasNext()) { // looping through all of the data
			int n = scan.nextInt(); // storing an individual number as int:n
			if (Math.abs(n)%2==1) { // checking if the particular n is odd or even
				System.out.println(n + " " + (0-n)); // if odd, printing the opposite value of n
			}
			else {
				System.out.println(n + " " + (0-n-1)); // if even, printing the complement of n
			}
		}
	}

}
