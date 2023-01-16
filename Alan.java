import java.io.*;
import java.util.*;
public class Alan {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("alan.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		int far = scan.nextInt();
		double ans = 5.0/9*(far-32)+273.15;
		System.out.printf("%d degrees Fahrenheight is equal to %1.2f Kelvin\n", far,ans);

	}

}
}
