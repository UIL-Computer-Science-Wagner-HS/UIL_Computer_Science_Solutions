import java.io.*;
import java.util.*;

public class Ones {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ones.dat"));
		while (scan.hasNext()) {
			long n = scan.nextInt();
			if (n % 2 == 0 || n % 5 == 0)
				System.out.println("INVALID INPUT");
			else {

			String str = "1";
				
				while(Long.parseLong(str)%n!=0)  
					str+="1";
				System.out.println(str.length());	
						
					

				

			}

		}

	}
}
