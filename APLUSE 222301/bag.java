import java.io.*;
import java.util.*;
public class bag {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("bag.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	label:
	while (noSets-- > 0) {
		char[] str = scan.nextLine().toCharArray();
		int counter = 1;
		Set<Character> set = new LinkedHashSet<>();
		for(int i = 0; i<str.length; i++) {
			set.add(str[i]);
			counter++;
			if((counter-1)%7==0) {
				if(set.size()<7) {
					System.out.println("Invalid Bag"+ set);
					continue label;
				}
				else set = new HashSet<>();
			}
		}
		System.out.println("Valid Bag");

	}

}
}
