import java.io.*;
import java.util.*;

public class ReversePals {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File("reversepals.dat"));
		
		int n = scan.nextInt(); // scanning in the number of lines that have to be looped through
		scan.nextLine();
		
		while(n-- > 0) {
			int iteration = 0; // counter: the number of iteration it will take to find a palindrome of a number
			
			int num = scan.nextInt(); // scanning in a digit that we need to find the palindrome of
			String num_str = Integer.toString(num); // converting num to String
			String num_reversestr = new StringBuilder (num_str).reverse().toString(); // finding the reverse of num
			while(!num_str.equals(num_reversestr)) { // checking if num_str equals num_reversestr, basically is the original number and the reversed number the same
				iteration++;
				int num_reverse = Integer.parseInt(num_reversestr);
				int sum = num + num_reverse;
				num = sum;
				num_str = Integer.toString(num); // converting num to String
				num_reversestr = new StringBuilder (num_str).reverse().toString(); // finding the reverse of num
				
			}
			
			System.out.println(num + " " + iteration);
		}
	}

}
