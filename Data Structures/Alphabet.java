import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Alphabet {
	
	static Map<Character, Character> mappings = new HashMap<>();
	
	static {
		for(char letter = 'A'; letter<='M'; letter++) {
			char matchingChar = (char)('Z'-(letter-65));
			mappings.put(letter, matchingChar);
			mappings.put(matchingChar, letter);
		}
	}
	
	public static boolean isOrdered(String input) {
		Stack<Character> soFar = new Stack<>();
		for(int i = 0;i<input.length(); i++) {
			char currentLetter = input.charAt(i);
			if(!soFar.isEmpty() && mappings.get(soFar.peek()) == currentLetter)
				soFar.pop();
			else
				soFar.add(currentLetter);
		}
		return soFar.isEmpty();
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("alphabet.dat"));
		int n = Integer.parseInt(scan.nextLine());
		while(n-->0)
			System.out.println(isOrdered(scan.nextLine())?"YES":"NO");
	}
}
