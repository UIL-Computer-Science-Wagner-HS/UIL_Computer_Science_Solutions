import java.io.*;
import java.util.*;

public class Melanie {
	static int fib(int n){
		if(n<=1)
			return 1;
		return n*fib(n-1);
		
	}
	static int denom = 1;
	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("melanie.dat"));
		int noSets = scan.nextInt();
		int count = 1;
		while (noSets-- > 0) {
			denom = 1;
			char[] arr = scan.next().toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for(char c: arr){
				map.putIfAbsent(c, 0);
				map.put(c, map.get(c)+1);
			}
		//System.out.println(map);
			map.entrySet().forEach(a->denom*=fib(a.getValue()));
			System.out.println(fib(arr.length)/denom);
			
			

		}

	}
}