import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Encryption {

	private static void findLCM(String[] numbers) {
		if (numbers.length<2) {
			System.out.println(numbers[0]);
			return;
		}
		
		int gcd = Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
		for (String current : numbers) {
			int product = gcd * Integer.parseInt(current);
			int currentGCD = new BigInteger(""+gcd).gcd(new BigInteger(current)).intValue();
			gcd = product/currentGCD;
		}
		
		System.out.println(gcd);
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("encryption.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] numbers = scan.nextLine().split(" ");
			findLCM(numbers);
		}
		scan.close();
	}

}
