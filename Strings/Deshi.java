package uil2013;
import java.io.*;
import java.util.*;

public class Deshi {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("deshi.dat"));
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			if(str.matches(".*[aeiou]{5}.*"))
				System.out.println("Not Acceptable "+str );
			else if(str.matches(".*[bcdfghjklmnpqrtsvwxyz]{8}.*"))
				System.out.println("Not Acceptable "+str );
			else
				
		System.out.println("Acceptable "+str );
		}
	}

}
