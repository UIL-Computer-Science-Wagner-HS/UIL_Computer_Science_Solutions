import java.io.*;
import java.util.*;
public class Sakshi {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("sakshi.dat"));
		
		while (scan.hasNext()) {
			double power = Math.pow(scan.nextDouble(), scan.nextDouble());
			System.out.printf("%.3f", power);
			System.out.println();
		}
		
	}

}
