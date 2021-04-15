import java.util.*;
import java.io.*;

public class Christina {
	
	static String rev(String str) {
		  StringBuilder b = new StringBuilder(str);
		  return b.reverse().toString();
		
		
	}
public static void main(String[] args) throws FileNotFoundException {
	Scanner scan = new Scanner(new File("christina.dat"));
	int n =  scan.nextInt();
	List<String> list = new ArrayList();
	while(n-->0) {
		list.add(scan.next());
		
	}
	while(scan.hasNext()) {
		String str = scan.next();
		int index = 0;
		
		String ans = "";
		while(index<str.length()) {
			int findString = Integer.parseInt(str.substring(index,index+2));
			String parser = list.get(findString-1);
			index+=2;
			char instruction = str.charAt(index++);
			switch(instruction) {
			case 'U': ans+=parser.toUpperCase();
			break;
			case 'L': ans+=parser.toLowerCase();
			break;
			case 'R':
				ans+=parser; break;
			case 'u':  parser = rev(parser);
				ans+=parser.toUpperCase(); break;
			case 'r': 	parser = rev(parser);
			ans+=parser.toLowerCase(); break;
			case 'l': parser =rev(parser);
				ans+=parser.toLowerCase(); break;
			
			
			}
			
		}
		System.out.println(ans);
		
		
	}
	
}
}
