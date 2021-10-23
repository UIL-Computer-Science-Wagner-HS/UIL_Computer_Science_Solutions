import java.io.*;
import java.util.*;
public class Hojin {
	
	static long gcd( long a , long b){
		if(b==0)
			return a;
		return gcd(b, a%b );
		
		
	}
	
public static void main(String[] args) throws FileNotFoundException {
	Scanner scan = new Scanner(new File("hojin.dat"));
	int noSets = scan.nextInt();
	while(noSets-->0){
		long a = scan.nextLong();
		long b = scan.nextLong();
		System.out.println(gcd(a,b));
		
		
		
	}
}
}
