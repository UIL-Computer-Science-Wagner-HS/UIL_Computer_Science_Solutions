import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
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
