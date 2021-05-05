import java.io.*;
import java.util.*;

public class Deshi {

	
	static boolean check(String str) {
		return(!(str.matches(".*[aeiou]{5}.*")||str.matches(".*[^aeiou]{5}.*")));	
	}
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("deshi.dat"));
		while(scan.hasNextLine()) {
			String str  = scan.nextLine();
			boolean check = !(str.matches(".*[aeiou]{5}.*")||str.matches(".*[^aeiou]{5}.*"));
			if(check) 
				System.out.println("ACCEPTABLE "+str );
			else
				System.out.println("UNACCEPTABLE "+str);
				
			
			
			
			
			
		}
		

	}

}
