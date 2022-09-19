import java.util.*;
import java.io.*;
public class beautiful {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner( new File("beauty"));
		int x = sc.nextInt();
		double amount = 0;
		while (x-- > 0) {
			String name = sc.next();
			amount += sc.nextDouble();
	}
		System.out.println("$" + amount);
	}
}
