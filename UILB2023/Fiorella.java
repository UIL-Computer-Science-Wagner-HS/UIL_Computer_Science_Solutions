import java.util.*;
import java.io.*;

public class Fiorella {
	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("fiorella.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			int w = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			int G = scan.nextInt();
			double ans = Math.log((G-z)/(w*y))/Math.log(x);
			System.out.println((int)ans);
		}
	}
}
