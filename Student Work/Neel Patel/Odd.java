import java.io.*;
import java.util.*;

public class Odd {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File("odd.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		
		while (n-- > 0) {
			String [] arr = scan.nextLine().split("");
			Arrays.sort(arr);
			for (String i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
