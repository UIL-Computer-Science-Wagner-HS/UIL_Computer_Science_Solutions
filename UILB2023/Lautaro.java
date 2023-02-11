import java.util.*;
import java.io.*;
public class Lautaro {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("Lautaro.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		System.out.println(scan.nextLine().matches("\\(\\d{3}\\) \\d{3}-\\d{4}")?"Valid phone number.": "No calls for you.");

	}
}
}
