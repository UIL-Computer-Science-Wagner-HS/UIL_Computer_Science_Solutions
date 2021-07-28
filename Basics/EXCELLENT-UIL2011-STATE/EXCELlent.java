import java.io.*;
import java.util.*;

public class EXCELlent {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("excellent.dat"));
		int names1 = scan.nextInt();
		int names2 = scan.nextInt();
		List<String> list1 = new ArrayList();
		List<String> list2 = new ArrayList();
		scan.nextLine();
		for (int i = 0; i < names1; i++)
			list1.add(scan.nextLine());
		for (int i = 0; i < names2; i++)
			list2.add(scan.nextLine());
		List<String> list11 = new ArrayList();
		List<String> list22 = new ArrayList();
		for(String s: list1)
			if(!list2.contains(s))
				list11.add(s);
		for(String s: list2)
		if(!list1.contains(s))
			list22.add(s);
		Collections.sort(list11);
		Collections.sort(list22);
		System.out.println("NAMES IN SPREADSHEET 1 THAT ARE NOT IN SPREADSHEET 2");
		for(String s: list11)
			System.out.println(s);
		System.out.println("NAMES IN SPREADSHEET 2 THAT ARE NOT IN SPREADSHEET 1");
		for(String s: list22)
			System.out.println(s);
	}
}
