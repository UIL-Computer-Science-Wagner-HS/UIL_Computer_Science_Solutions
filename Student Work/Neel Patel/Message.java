import java.io.*;
import java.util.*;

public class Message {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("message.dat")); // scanning in the file with data
		
		int n =  scan.nextInt(); // scanning the number of messages
		scan.nextLine();
		
		while (n-- > 0) { // looping through all of the data sets
			int len = scan.nextInt(); // scanning the length that we will need to extract from the data (extracting the letters matching the length)
			scan.nextLine();
			
			String arr[] = scan.nextLine().split("[\\p{Punct}\\s+]");
			String str = "";
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].length() == len) {
					str += arr[i] + " ";
				}
			}
			System.out.println(str);// printing the result out
		}
	}

}
