import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Petra {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("petra.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.next();
		BigInteger num = new BigInteger(new StringBuilder(str).reverse().toString());
		BigInteger gcd = num.gcd(new BigInteger(str));
		System.out.println(gcd);

	}
}
}
