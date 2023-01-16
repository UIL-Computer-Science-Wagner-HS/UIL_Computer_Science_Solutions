import java.io.*;
import java.util.*;
public class Bianca {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("bianca.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		System.out.printf("%1.2f\n", Math.sqrt(Math.pow(scan.nextInt(), 2)+Math.pow(scan.nextInt(), 2)));

	}

}
}
