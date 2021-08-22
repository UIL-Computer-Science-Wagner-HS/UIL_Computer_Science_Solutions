import java.io.*;
import java.util.*;

public class pr58 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr58.dat"));
		int noSets = scan.nextInt();
		List<String> list = new ArrayList();
		while(noSets-->0)
			list.add(scan.next());
		Comparator<String> comp2 = (a,b)->a.charAt(1)-b.charAt(1);
		Comparator<String> comp4 = (a,b)->a.charAt(3)-b.charAt(3);
		list.sort(comp2.thenComparing(comp4));
		list.forEach(System.out::println);
			
			
		
		

	}
}
