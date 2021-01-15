import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class pizza_diameter {
	
	public static double getDiameter(double area) {
		return 2*Math.sqrt(area/Math.PI);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pizza_diameter.dat"));
		int noCases = scan.nextInt();
		for(int i = 1; i<=noCases; i++)
			System.out.printf("Pizza %d should have a diameter of %.3f inches%n", i, getDiameter(scan.nextDouble()));
		scan.close();
	}

}
