import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 * Class represents calculations with ordered pairs of decimal values.
 *Multiplication: (a,b) * (c,d) = (a*c - b*d, a*d+b*c)
 *Exponentation is repeated multiplication
 *Given a single instance of N in the above system and an integer m, write a program that prints out the value N^m (N*N*N m times)
 *The first line has an integer T, with T data sets to follow.
 *Each data set contains two decimal values a, and b, representing the ordered pair (a,b), followed by an integer M representing the exponent.
 *For each test case, output the answer as an orderd pair, bracketed as shown, without spaces.
 */
public class Exponentiation {
	
	private static double a, b;
	private static int exponent;
	
	private static double newA, newB;
	
	public static void process() {
		newA = a;
		newB = b;
		for(int i = 0;i<exponent-1 ;i++) {
			multiply();
		}
		
		System.out.println("("+newA+","+newB+")");
	}
	
	public static void multiply() {
		double aCopy = newA;
		
		newA = newA*a-newB*b;
		newB = aCopy*b+newB*a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("exponentiation.dat"));
		int noOfTimes = Integer.parseInt(scan.nextLine());
		while(noOfTimes-->0) {
			a = scan.nextDouble();
			b = scan.nextDouble();
			exponent = Integer.parseInt(scan.nextLine().trim());
			process();
		}
		
		scan.close();
		

	}

}
