import java.util.*;
import java.io.*;

/**
 * @author Ian Fernandes
 *
 */
public class text_search {
	
	public static void findInstances(String sentence, String target, int begIndex, int lineNum) { // Alternate approach to indexOf(str, index)
		int index = sentence.indexOf(target);
		if(index==-1)
			return;
		System.out.printf("line %d character %d%n", lineNum, begIndex+index+1); // 1-based indexing when displaying
		findInstances(sentence.substring(index+1), target, index+1, lineNum);
	}
	
	public static void findInstances(String sentence, String target, int lineNum) { // Using indexOf(str, index)
		int index = sentence.indexOf(target);
		while(index!=-1) {
			System.out.printf("line %d character %d%n", lineNum, index+1);			
			index = sentence.indexOf(target, index+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("text_search.dat"));
		String target = scan.nextLine().toLowerCase();
		int lineNum = 1;
		while(scan.hasNextLine())
			// findInstances(scan.nextLine().toLowerCase(), target, 0, lineNum++); // Only possible problem is when you have MANY (1000+) string matches (because of recursion and call stack)
			findInstances(scan.nextLine().toLowerCase(), target, lineNum++);
	}
}
