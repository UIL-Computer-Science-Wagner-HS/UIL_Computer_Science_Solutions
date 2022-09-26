import java.io.*;
import java.util.*;

public class Burpees {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("burpees.dat")); // scanning in the file with data
		
		int n = scan.nextInt(); // the number of people participating in the burpees challenge
		scan.nextLine();
		
		while (n -- > 0) { // looping through every person that is participating
			int days = scan.nextInt(); // scan the number of days the person is going to do the burpees challenge for
			int total_burpees = counter(days); // passing the days to the recursive method and storing teh return value as total burpees
			System.out.println(total_burpees); // printing the total number of burpees
		}
	}
	//using recursion to calculate the count of burpees (the coutn is as follow one burpee on day one, two burpees on day  two three on day 3, four on day four, and so on...)
	static int counter(int days) {
		if (days > 0 ) {
			return days + counter(days-1);
		}
		else {
			return 0;
		}
		
	}

}
