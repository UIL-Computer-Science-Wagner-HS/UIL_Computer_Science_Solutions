import java.util.*;
import java.io.*;
public class Karen {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("karen.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		int n = scan.nextInt();
		double root = Math.sqrt(n);
		int lower = (int) root;
		int higher = lower+1;
		int lowDif = Math.abs(n-lower*lower);
		int highDif = Math.abs(n-higher*higher);
		int ans = Math.min(lowDif, highDif);
		System.out.println(lowDif>=highDif?higher*higher:lower*lower );

	}
}
}
