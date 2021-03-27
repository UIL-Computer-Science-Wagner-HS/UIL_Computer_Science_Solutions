/**
 * 
 */
package invitationalA2021;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ian Fernandes
 *
 */
public class Hai {
	
	static ArrayList<String> getMatches(String text, String regex) {
		ArrayList<String> matches = new ArrayList<>();
		String[] words = text.split("\\s+");
		for(String word: words)
			if(word.matches(regex))
				matches.add(word);
		if(matches.size()==0)
			matches.add("No matches.");
		return matches;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("hai.dat"));
		String text = scan.nextLine();
		int numToCheck = Integer.parseInt(scan.nextLine());
		while(numToCheck-->0) {
			String regex = scan.nextLine();
			System.out.printf("%-10s", regex);
			ArrayList<String> matches = getMatches(text, regex);
			for(String match: matches)
				System.out.print(match+" ");
			System.out.println();			
		}
	}
}
