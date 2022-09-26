import java.io.*;
import java.util.*;


public class StrongPasswords {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("strong.dat"));
		
		int n = scan.nextInt(); //  scanning in the number of lines that have to be looped through
		scan.nextLine();
		
		//strong password criteria
		String upper_a_z = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower_a_z = upper_a_z.toLowerCase();
		String nums = "0123456789";
		String special_char = "!@#$%^&*()_+=";
		

		//looping through all the password
		while (n-- > 0) {
			
			//setting all criteria to false using new variables
			boolean contains_upper = false;
			boolean contains_num = false;
			boolean contains_special = false;
			boolean other_char = false;
			
			String[] pass = scan.nextLine().split(""); // creating a String array filled with each individual char of the password
			
			
			if (pass.length >= 8) { // making sure that length of the password is greater than or equal to 8 digits
				for(int i = 0; i < pass.length; i++) {
					if ((upper_a_z.contains(pass[i]))||(lower_a_z.contains(pass[i]))||(nums.contains(pass[i]))||(special_char.contains(pass[i]))){// checking if the each element of the array is a valid char
						if(upper_a_z.contains(pass[i])==true) // if there is one case of upper case letter, it turns the contains_upper boolean true
							contains_upper = true; 
						if(special_char.contains(pass[i])==true) // if there is one case of special char, it turns the contains_special boolean true
							contains_special = true;
						if(nums.contains(pass[i])==true) // if there is one number, it turns the contains_num boolean true
							contains_num = true;
					}
					else { // if there is an invalid char, it turn the other_char boolean true
						other_char = true;
					}
				}
			}

			if ((contains_upper == true || contains_special == true) && (contains_num == true) && (other_char == false)) // if all of the criteria is met, the system outputs "STRONG"
				System.out.println("STRONG");
			else // if all of the criteria is not met, the system outputs "INVALID"
				System.out.println("INVALID");
			
		}
		
	}

}
