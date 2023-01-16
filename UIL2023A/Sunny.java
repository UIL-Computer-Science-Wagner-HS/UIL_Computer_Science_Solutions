import java.io.*;
import java.util.*;
public class Sunny {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("sunny.dat"));
	
	List<String> list = new ArrayList<>();
	while (scan.hasNextLine()) {
		String str = scan.next(); 
		String end = scan.nextLine().trim();
		list.add(end+" ("+str+")");
		}
	Collections.sort(list);
	for(String s: list)
		System.out.println(s);

}
}
