import java.util.*;
import java.io.*;

public class Vinay {
	
	static long fibon(long sum) {
		long tot = 1;
		for (long i = sum; i > 0; i--) {
			tot *= i;

		}

		return tot;

	}

	static long count(Map<Character, Integer> map) {
		long sum = 0;
		for (Map.Entry<Character, Integer> ent : map.entrySet())
			if (ent.getValue() % 2 == 1)
				sum++;

		return sum;
	}

	static long compute(Map<Character, Integer> map) {
		List<Integer> list = new ArrayList<>();
		long sum = 0;
		for (Map.Entry<Character, Integer> ent : map.entrySet())
			if (ent.getValue() % 2 == 0) {
				int n = ent.getValue();
				list.add(n/2);
				sum += n/2;

			}
		//System.out.println(list);
		long prod = 1;
		for(int element: list)
			prod*=fibon(element);
		long ans = fibon(sum)/prod;
		return ans;

	}

	public static void main(String... args) throws IOException {

		Scanner scan = new Scanner(new File("vinay.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while (noSets-- > 0) {
			String str = scan.nextLine();
			String change = str.toLowerCase().replaceAll("\\W", "");
			Map<Character, Integer> map = new HashMap<>();
			char[] arr = change.toCharArray();
			
			//System.out.println(change);
			for (char c : arr) {
				map.putIfAbsent(c, 0);
				map.put(c, map.get(c) + 1);

			}
			//System.out.println(map);
			long odds = count(map);
			//System.out.println();
			if (odds > 1)
				System.out.println(str + " cannot be rearranged to form a palindrome.");
			else if (odds == 1 && change.length() % 2 == 0)
				System.out.println(str + " cannot be rearranged to form a palindrome.");
			else {
				long n = compute(map);
				System.out.println(str+ " can be rearranged to form "+ n+" palindromes(s).");
				
			}

		}
	}
}
