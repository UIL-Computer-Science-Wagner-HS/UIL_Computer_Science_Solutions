/**
 * 
 */
package region2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Caleb.java | Input: caleb.dat | UIL Region 2018
 * @author Ian Fernandes
 *
 */
public class Caleb {
	
	public static void process(String input) {
		int bogHours = Integer.parseInt(input.split("/")[0]);
		int bogMinutes = Integer.parseInt(input.split("/")[1]);
		
		int hours = 12;
		int minutes = 0;
		
		//For every 30 degrees, an hour passes
		while(bogHours>0) {
			bogHours-=30;
			if(bogHours>=0)
				hours++;
		}
		if(hours>12)
			hours-=12;
		
		//For ever 6 degrees, a minute passes
		while(bogMinutes>0) {
			bogMinutes-=6;
			if(bogMinutes>=0)
				minutes++;
		}
		System.out.printf(hours+":%02d%n", minutes);
	}

	/**
	 * Convert Bogswamistan time to standard US time in hours and minutes
	 * See problem image in subfolder for more information on Bogswamistan time.
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("caleb.dat"));
		int no = Integer.parseInt(scan.nextLine());
		
		while(no-->0) {
			process(scan.nextLine());
		}
		
		scan.close();
		

	}

}
