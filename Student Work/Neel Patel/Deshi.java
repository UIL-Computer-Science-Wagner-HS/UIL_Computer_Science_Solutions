import java.io.*;
import java.util.*;


public class Deshi {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner (new File("deshi.dat")); // scanning in the data file
		
		
		while(scan.hasNext()) { // loops through all of the data in the file
			String str[] = scan.nextLine().split(""); // scans each line and turns it into an array
			
			int vowels_counter = 0; // initializes the counter for vowels
			int consonant_counter = 0; // initializes the counter for consonant
			
			for (int i = 0; i < str.length;i++) { // looping through the string array
				if (vowels_counter == 5 || consonant_counter == 8) { // checking if the string fails the criteria
					break; // breaks the loop
				}
				if (str[i].matches("[aeiou]")) { // sees if the string array contains vowels, if so:
					consonant_counter = 0; // sets the consonant_counter to 0
					vowels_counter++; // increases the counter for vowels
				}
				if (str[i].matches("[^aeiou]")) { // sees if the string array contains vowels, if so:
					vowels_counter = 0; // sets the vowels_counter to 0
					consonant_counter++; // increases the counter for consonant
				}
				
			}

			
			String str_print = ""; // creates an empty string to turn the array back into a String
			for(String i : str) // makes the array into a String
				str_print += i;
			
			if (vowels_counter == 5 || consonant_counter == 8) { // printing output if the criteria is failed
				System.out.println("NOT ACCEPTABLE" + " " + str_print);
			}
			else { // printing output if the criteria is met
				System.out.println("ACCEPTABLE" + " " + str_print);
			}
		}
	}
	
}
