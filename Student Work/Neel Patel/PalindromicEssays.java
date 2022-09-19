import java.io.*;
import java.util.*;

public class PalindromicEssays {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("palindrome.dat"));
		
		//No. of Essays
		int n = scan.nextInt();
		scan.nextLine();
		
		//TreeMap to store palindromic and its count
		TreeMap <String, Integer> map = new TreeMap <> ();

		for (int i = 1; i <= n; i++) {
			String str = scan.next();
			while (!str.equals("-")) { // continues till the terminating case "-"
				if(str.substring(str.length()-1).equals(",") || str.substring(str.length()-1).equals(".")) // removes the commas and periods
					str = str.substring(0,str.length()-1);
				StringBuilder temp = new StringBuilder(str); // stores original string as StringBuilder (temporary)
				String reverse_str = temp.reverse().toString(); // reverse the original string
				if (str.equals(reverse_str)) { // check is the original string and the reverse string are equal; if so add it to TreeMap
					if (!map.containsKey(str)) {
						map.put(str,1);
					}
					else {
						int count = map.get(str);
						count++;
						map.put(str, count);
					}
				}
				str=scan.next();
			}
			System.out.println("ESSAY # " + i); // prints the essay number
			while(map.size()>0) { //prints the palindromic and the number of times it appears (if > 1) in Palindromic ESSAY #
				if (map.firstKey().length()>1) {
					System.out.print(map.firstKey() + " ");
					if (map.get(map.firstKey())>1) {
						System.out.println("(" + map.get(map.firstKey())+ ")");
					}
					else {
						System.out.println();
					}
				}
				map.remove(map.firstKey());
			}
			System.out.println();
		}
		
	
	}

}
