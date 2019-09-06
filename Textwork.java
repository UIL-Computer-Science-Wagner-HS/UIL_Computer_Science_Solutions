import java.util.*;
import java.io.*;

public class Textwork {
	
	private static int noWords, noVowels, noConsonants, noPunctuation;
	
	private static void processWord(String current) {
		
		for(int i = 0;i<current.length();i++) {
			
			String currentLetter  = current.substring(i, i+1);
			
			if(currentLetter.matches("[aeiou]"))
				noVowels++;
			else if(currentLetter.matches("\\w"))
				noConsonants++;
			else
				noPunctuation++;
		}
	}
	
	private static void printResults() {
		
		System.out.println("Words: "+noWords);
		System.out.println("Vowels: "+noVowels);
		System.out.println("Consonants: "+noConsonants);
		System.out.println("Punctuation Marks: "+noPunctuation);
		
	}
	
	public static void main(String[] args)throws IOException {
		
		Scanner scan = new Scanner(new File("textwork.dat"));
		
		while(scan.hasNext()) {
			processWord(scan.next());
			noWords++;
		}
		
		printResults();
		
		scan.close();
	}

}
