import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Lavanya {
	static List<Integer>list;
	static void populate(int check) {
		int prime = 2;
		while(check>1) {
			if(isPrime(prime)&&check%prime==0) {
				list.add(prime);
				check/=prime;
			}
			else {
			prime = prime+1;
			//System.out.println(prime);	
			}
		}
		
	}
	static boolean isPrime(int n) {
		BigInteger check = new BigInteger(n+"");
		return check.isProbablePrime(10);
		
	}
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("lavanya.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			list = new ArrayList<>();
			int check = scan.nextInt();
			populate(check);
			//System.out.println(list);
			System.out.print(check+" = ");
			for(int i = 0; i<list.size()-1; i++)
				System.out.print(list.get(i)+" * ");
			System.out.println(list.get(list.size()-1));
			
		}
		
}
}