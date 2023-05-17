import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Circ {
	
	static BigInteger rot(int n, int i) {
		List<Integer> list = new ArrayList<>();
		while(n>0) {
			list.add(0,n%10);
			n/=10;
			
		}
		Collections.rotate(list, i);
		String ans = "";
		for(int num: list)
			ans+=num;
		return new BigInteger(ans);		
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("circ.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int low = scan.nextInt();
			//System.out.println(low);
			int high = scan.nextInt();
			int count = 0;
			for(int n = low; n<=high; n++) {
			boolean flag = true;
			for(int i = 0 ; i<(n+"").length(); i++) {
				BigInteger big = rot(n,i);
				if(!big.isProbablePrime(7))
					flag = false;
				}
			if(flag) {
				System.out.println(n);
				
				count++;
			}
			
			}
			if(count==0) {
				System.out.println("None");				
			}
			System.out.println();
		}
	}
}
