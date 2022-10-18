import java.io.*;
import java.util.*;

public class Linus {
	public static void main(String[] args) throws FileNotFoundException {
		// THE GOAL OF THE PROGRAM IS TO SIMPLIFY FRACTIONS (NOTE: THERE WON'T BE ANY NEGATIVE FRACTONS OR DENOMINATOR WITH ZERO, IN ANY OF THE PROBLEMS)
		
		Scanner scan = new Scanner(new File("linus.dat")); // scanning in the file that contains the data
		
		int n = scan.nextInt(); // the number of lines consisting of data
		
		while (n-- > 0) { // looping through all of the data
			//scanning in the set of a fraction
			int numerator = scan.nextInt(); // scanning in the numerator 
			int denominator = scan.nextInt(); // scanning in the denominator
			
			String simplified = simplify(numerator,denominator); // passing the numerator and the denominator into the method: simplify.
			System.out.println(simplified); // printing the final simplified fraction
		}
		
	}
	// METHOD TO SIMLYFIY FRACTIONS
	static String simplify(int numerator, int denominator) {
		String str = ""; // initializing an empty string (this will be the final simplified fraction)
		if (denominator >= numerator) { // if the denominator is greater than equal to the numerator
			str = (numerator) + "/" + (denominator); // str is equal to numerator divided by denominator (this is for the cases where the simplified answer is 1 such as 7/7, or 6/6)
			for (int i = denominator; i > 1; i --) { // starting at the integer of the denominator and looping through to find the highest common factor
				if (numerator%i == 0 && denominator%i == 0) { // if the most highest factor is found
					if (denominator/i == 1) { // if the the denominator is 1 such as 7/1
						str = ""+ numerator/i; // simplifies the str to just the integer such as 7/1 --> 7
						break; // to exit
					}
					str = (numerator/i) + "/" + (denominator/i); // otherwise divide both the numerator and the denominator by the highest common factor
					break; // to exit
				}
			}
			
		}
		else { // if the numerator > denominator (i.e. in most cases for whole number)
			int mixed_whole = numerator/denominator; // to find the whole of the mixed number
			int mixed_numerator = numerator%denominator; // to find the numerator of the mixed number
			str = mixed_whole + " " + mixed_numerator + "/" + denominator; // str is set to the mixed number
			if (mixed_numerator == 0) { // if the mixed numerator is 0, then:
				str = ""+ mixed_whole; // mixed whole is set as str
			}
		}
		
		return str; // return the simplified fraction
	}

}

