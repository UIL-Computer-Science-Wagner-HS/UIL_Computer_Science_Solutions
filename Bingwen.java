/**
 * 
 */
package region2018;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Bingwen.java | Input: bingwen.dat | UIL Region 2018
 * @author Ian Fernandes
 *
 */
public class Bingwen {

	/**
	 * Calculate the cubed root of each line of input
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("bingwen.dat"));
		while(scan.hasNextLine()) {
			System.out.printf("%.2f%n",Math.cbrt(Integer.parseInt(scan.nextLine())));
		}
		scan.close();

	}

}
