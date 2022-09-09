import java.io.*;
import java.util.*;

public class BeautifulNaturally {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("beautiful.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		double total = 0.0;
		
		while (n-- > 0) {
			String arr [] = scan.nextLine().split(" ");
			total += Double.parseDouble(arr[1]);
		}
		System.out.printf("$" + "%.2f", total);
	}
}
