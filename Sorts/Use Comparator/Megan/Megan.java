import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Megan {
	
	static String alphabet;
	
	static class Word implements Comparable<Word>{
		String word;
		
		public Word(String word) {
			this.word = word;
		}

		@Override
		public int compareTo(Megan.Word other) {
			for(int i = 0; i<Math.min(word.length(), other.word.length()); i++) {
				char firstChar = word.charAt(i), otherChar = other.word.charAt(i);
				if(firstChar==otherChar)
					continue;
				return alphabet.indexOf(word.charAt(i))-alphabet.indexOf(other.word.charAt(i));
			}
			return word.length()-other.word.length();
		}
		
		public String toString() {
			return word;
		}
	}
	
	static boolean isSorted(String alphabet, String[] list) {
		ArrayList<String> unsortedWords = new ArrayList<>(Arrays.asList(list));
		ArrayList<Word> sortedWords = new ArrayList<>();
		unsortedWords.forEach(word->sortedWords.add(new Word(word)));
		Collections.sort(sortedWords);
		return (""+unsortedWords).equals(""+sortedWords);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("megan.dat"));
		int n = Integer.parseInt(scan.nextLine());
		for(int i = 1; i <= n; i++) {
			alphabet = scan.nextLine();
			String[] list = scan.nextLine().split(",");
			if(i!=n)
				scan.nextLine();
			System.out.println("Word List "+i+" is "+(isSorted(alphabet, list)?"":"not ")+"sorted.");
		}
	}
}
