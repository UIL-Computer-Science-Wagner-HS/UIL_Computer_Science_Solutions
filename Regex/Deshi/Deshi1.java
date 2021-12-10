import java.io.*;
import java.util.*;

public class Deshi {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("deshi.dat"));
		while(scan.hasNextLine()) {
			String str = scan.next();
			if(str.matches(".*[aeiou]{5,}.*")||str.matches(".*[bcdfghjklmnpqrstvwxyz]{8,}.*"))
				System.out.println("NOT ACCEPTABLE "+str);
			else
				System.out.println("ACCEPTABLE "+str);
			
			
		}
	}
}
//[aeiou][aeiou][aeiou][aeiou]
