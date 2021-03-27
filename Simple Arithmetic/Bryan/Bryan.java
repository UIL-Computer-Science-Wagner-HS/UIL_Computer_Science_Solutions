/**
 * 
 */
package invitationalA2021;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Ian Fernandes
 *
 */
public class Bryan {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("bryan.dat"));
		int w = scan.nextInt();
		for(int i = 1; i<=w; i++) {
			int net = 0;
			int n = scan.nextInt();
			while(n-->0) {
				scan.next();
				net += scan.nextInt();
			}
			System.out.print("Case #"+i+": ");
			if(net > 0)
				System.out.println("Wow, Bryan saved $"+net);
			else if(net < 0)
				System.out.println("Oh no! Bryan had to borrow $"+net*-1);
			else
				System.out.println("Phew, broke even!");
		}
	}
}
