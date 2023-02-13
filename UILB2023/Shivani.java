import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Shivani {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("shivani.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	BigInteger three = new BigInteger("3");
	BigInteger six = new BigInteger("6");
	BigInteger two = new BigInteger("2");
	while (noSets-- > 0) {
		BigInteger b1 = new BigInteger(scan.next());
		BigInteger cube = b1.multiply(b1).multiply(b1);
		BigInteger sq = b1.multiply(b1);
		sq = sq.multiply(three);
		b1 = b1.multiply(two);
		BigInteger sum = cube.add(sq);
		sum = sum.add(b1);
		sum = sum.divide(six);
		System.out.println(sum);
		
	}
}
}

// The forumla for the nth triangular pyramidal number is (n^3+3n^2+2n)/6
