import java.io.*;
import java.util.*;
public class Priyanka {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("priyanka.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.next();
		String vowels = str.replaceAll("[^AEIOU]","");
		String cons = str.replaceAll("[AEIOU]", "");
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		for(int i = 0; i<vowels.length(); i++)
			list1.add(vowels.charAt(i));
		for(int i = 0; i<cons.length(); i++)
			list2.add(cons.charAt(i));
		Collections.sort(list1);
		Collections.reverse(list1);
		Collections.sort(list2);
		String ans = "";
		for(char s: list1)
			ans+=s;
		for(char s: list2)
			ans+=s;
		if(!ans.equals(str))
			System.out.println(ans);
		else System.out.println("WOO-HOO "+ str);
		

	}

}
}
