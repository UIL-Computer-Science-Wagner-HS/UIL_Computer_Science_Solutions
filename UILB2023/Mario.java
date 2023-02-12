import java.util.*;
import java.io.*;
public class Mario {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("mario.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		int n = scan.nextInt();
		String str = scan.next();
		if(n>str.length())
			System.out.println("error");
		else if(n>str.length()/2)
			System.out.println(new StringBuilder(str).reverse());
		else {
			String left = str.substring(0,n);
			String right = str.substring(str.length()-n);
			String ans = new StringBuilder(right).reverse().toString()+str.substring(n,str.length()-n)+ new StringBuilder(left).reverse().toString();		
			System.out.println(ans);
		}

	}
}
}
